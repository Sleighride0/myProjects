package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
    }

    @Test
    public void getParkById_with_valid_id_returns_correct_park() {
        Park park = sut.getParkById(1);
        assertParksMatch(PARK_1, park);

        park = sut.getParkById(2);
        assertParksMatch(PARK_2, park);
    }

    @Test
    public void getParkById_with_invalid_id_returns_null_park() {
        Park park = sut.getParkById(11);
        Assert.assertNull(park);
    }

    @Test
    public void getParksByState_with_valid_state_returns_correct_parks() {
        List<Park> parkList = sut.getParksByState("AA");
        Assert.assertEquals(2, parkList.size());
        assertParksMatch(PARK_1, parkList.get(0));
        assertParksMatch(PARK_3, parkList.get(1));

        parkList = sut.getParksByState("BB");
        Assert.assertEquals(1, parkList.size());
        assertParksMatch(PARK_2, parkList.get(0));
    }

    @Test
    public void getParksByState_with_invalid_state_returns_empty_list() {
        List<Park> parkList = sut.getParksByState("DD");
        Assert.assertEquals(0, parkList.size());
    }

    @Test
    public void createPark_creates_park() {
        Park parkTest = new Park();
        parkTest.setParkName("Test name");
        parkTest.setDateEstablished(LocalDate.now());
        Park park = sut.createPark(parkTest);
        Assert.assertNotNull(park);
        parkTest.setParkId(park.getParkId());//dont hard code this, this helps check the serial id
        assertParksMatch(parkTest,park);
    }

    @Test
    public void updatePark_updates_park() {
        Park park = new Park(1, "test",LocalDate.now(),555, true);
        Park updated = sut.updatePark(park);
        assertParksMatch(park, updated);
    }

    @Test
    public void deleteParkById_deletes_park() {
        int rowsDeleted = sut.deleteParkById(1);
        Assert.assertEquals(1,rowsDeleted);
        Park parkNotFound = sut.getParkById(1);
        Assert.assertNull(parkNotFound);
    }

    @Test
    public void linkParkState_adds_park_to_list_of_parks_in_state() {
        int countOfParksInBB = sut.getParksByState("BB").size();
        sut.linkParkState(1,"BB");
        List<Park> parksInBB = sut.getParksByState("BB");
        Assert.assertEquals(2,parksInBB.size());
        assertParksMatch(PARK_1, parksInBB.get(0));
    }

    @Test
    public void unlinkParkState_removes_park_from_list_of_parks_in_state() {
        Assert.fail();
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
