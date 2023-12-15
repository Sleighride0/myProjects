package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");

    private JdbcTimesheetDao dao;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheetById_with_valid_id_returns_correct_timesheet() {
        Timesheet timesheet = dao.getTimesheetById(1);
        assertTimesheetsMatch(TIMESHEET_1, timesheet);

        timesheet = dao.getTimesheetById(2);
        assertTimesheetsMatch(TIMESHEET_2, timesheet);


    }

    @Test
    public void getTimesheetById_with_invalid_id_returns_null_timesheet() {
        Timesheet timesheet = dao.getTimesheetById(11);
        Assert.assertNull(timesheet);
    }

    @Test
    public void getTimesheetsByEmployeeId_with_valid_employee_id_returns_list_of_timesheets_for_employee() {
        List<Timesheet> timesheetList = dao.getTimesheetsByEmployeeId(1);
        Assert.assertEquals(2, timesheetList.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheetList.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheetList.get(1));

    }

    @Test
    public void getTimesheetsByProjectId_with_valid_id_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheetList = dao.getTimesheetsByProjectId(1);
        Assert.assertEquals(3, timesheetList.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheetList.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheetList.get(1));
    }

    @Test
    public void createTimesheet_creates_timesheet() {
        Timesheet timesheetTest = new Timesheet();
        timesheetTest.setEmployeeId(2);
        timesheetTest.setProjectId(2);
        timesheetTest.setDateWorked(LocalDate.now());
        timesheetTest.setHoursWorked(10);
        timesheetTest.setBillable(true);
        timesheetTest.setDescription("Timesheet 5");
        Timesheet newSheet = dao.createTimesheet(timesheetTest);
        Assert.assertNotNull(timesheetTest);
        timesheetTest.setTimesheetId(newSheet.getTimesheetId());
        assertTimesheetsMatch(timesheetTest, newSheet);
    }

    @Test
    public void updateTimesheet_updates_timesheet() {
        Timesheet timesheetTest = new Timesheet(1, 2, 2,
                LocalDate.parse("2021-01-01"), 1.0, false, "Timesheet 1");
        Timesheet updated = dao.updateTimesheet(timesheetTest);
        assertTimesheetsMatch(timesheetTest, updated);
    }

    @Test
    public void deleteTimesheetById_deletes_timesheet() {
        int rowsDeleted = dao.deleteTimesheetById(4);
        Assert.assertEquals(1,rowsDeleted);
        Timesheet sheetNotFound = dao.getTimesheetById(4);
        Assert.assertNull(sheetNotFound);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        double totalHours = dao.getBillableHours(1,1);
        Assert.assertEquals(2.5, totalHours, .01);

        totalHours = dao.getBillableHours(2,2);
        Assert.assertEquals(2, totalHours, .01);
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
