package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Park;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getParkCount() {
        int parkCount = 0;
        String sql = "SELECT COUNT(*) AS count FROM park;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		if (results.next()) {
			parkCount = results.getInt("count");
		} 
        return parkCount;
    }
    
    @Override
    public List<String> getParkNames() {
        List<String> parkNames = new ArrayList<>();
        String sql = "SELECT park_name FROM park ORDER by park_name ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            parkNames.add(results.getString("park_name"));
        }
        return parkNames;
    }
    
    @Override
    public Park getRandomPark() {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park ORDER BY RANDOM() LIMIT 1;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()) {
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksWithCamping() {
        List<Park> parks = new ArrayList<>();
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park " +
                     "WHERE has_camping = true;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            parks.add(mapRowToPark(results));
        }
        return parks;
    }

    @Override
    public Park getParkById(int parkId) {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park " +
                     "WHERE park_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
        if (results.next()) {
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        List<Park> parks = new ArrayList<>();
        String sql = "SELECT p.park_id, park_name, date_established, area, has_camping " +
                     "FROM park p " +
                     "JOIN park_state ps ON p.park_id = ps.park_id " +
                     "WHERE state_abbreviation = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        while (results.next()) {
            parks.add(mapRowToPark(results));
        }
        return parks;
    }

    @Override
    public Park createPark(Park parky) {
        //know about a park - because parky was passed in
        String sql = "INSERT INTO park (park_name, date_established, area, has_camping)\n" +
                "VALUES (?, ?, ?, ?) RETURNING park_id;";

        String parkName = parky.getParkName();
        LocalDate parkEstDate = parky.getDateEstablished();
        double parkArea = parky.getArea();
        boolean parkHasCamping = parky.getHasCamping();
        try {
            int parkId = jdbcTemplate.queryForObject(sql, int.class, parkName, parkEstDate, parkArea, parkHasCamping);
            parky.setParkId(parkId);
        }catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Couldn't connect to database. Please contact someone who cares.", e);
        }catch(DataIntegrityViolationException e){
            throw new DaoException("Your attempt to add data to this table violates data integrity.", e);
        }


        return parky;
       // throw new DaoException("createPark() not implemented");
    }

    @Override
    public Park updatePark(Park park) {
        String sql = "UPDATE park \n" +
                "SET park_name = ?, date_established = ?, area = ?, has_camping = ?\n" +
                "WHERE park_id = ?;";

        try{
            int numOfRowsUpdated = jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(), park.getArea(), park.getHasCamping(), park.getParkId());
            if(numOfRowsUpdated == 0){
                throw new DaoException("No records were updated");
            }
        }catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Couldn't connect to database. Please contact someone who cares.", e);
        }catch(DataIntegrityViolationException e){
            throw new DaoException("Your attempt to add data to this table violates data integrity.", e);
        }

       return park;
    }

    @Override
    public int deleteParkById(int parkId) {
        throw new DaoException("deleteParkById() not implemented");
    }

    @Override
    public void linkParkState(int parkId, String stateAbbreviation) {
        String sql = "INSERT INTO park_state(park_id, state_abbreviation)\n" +
                "VALUES(?,?);";

        try{
            jdbcTemplate.update(sql,parkId,stateAbbreviation);
        }catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Couldn't connect to database. Please contact someone who cares.", e);
        }catch(DataIntegrityViolationException e){
            throw new DaoException("Your attempt to add data to this table violates data integrity.", e);
        }

    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();
        park.setParkId(rowSet.getInt("park_id"));
        park.setParkName(rowSet.getString("park_name"));
        park.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        park.setArea(rowSet.getDouble("area"));
        park.setHasCamping(rowSet.getBoolean("has_camping"));
        return park;
    }
}
