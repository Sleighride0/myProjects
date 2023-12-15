package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.SQLErrorCodes;
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
        int countOfParks = 0;
        String sql = "SELECT COUNT(*) AS count_of_parks FROM park;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if(results.next()){
            countOfParks = results.getInt("count_of_parks");
        }
        return countOfParks;
    }
    
    @Override
    public LocalDate getOldestParkDate() {
        LocalDate oldestParkDateEst = null;
        String sql = "SELECT MIN(date_established) AS oldest_park \n" +
                "FROM park;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if(results.next()){
            oldestParkDateEst = results.getDate("oldest_park").toLocalDate();
        }
        return oldestParkDateEst;
    }
    
    @Override
    public double getAverageParkArea() {
        double avgArea = 0.00;
        String sql = "SELECT AVG(area) AS avg_park_area FROM park;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if(results.next()){
            avgArea = results.getDouble("avg_park_area");
        }
        return avgArea;
    }
    
    @Override
    public List<String> getParkNames() {
        List<String> parkNames = new ArrayList<>();
        String sql = "SELECT park_name FROM park;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            parkNames.add(results.getString("park_name"));
        }
        return parkNames;
    }
    
    @Override
    public Park getRandomPark() {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping FROM park\n" +
                "ORDER BY RANDOM()\n" +
                "LIMIT 1;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if(results.next()){
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksWithCamping() {
        List<Park> parksWithCamping = new ArrayList<>();
        String sql = "SELECT park_id, park_name, date_established, area, has_camping FROM park\n" +
                "WHERE has_camping = true;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Park park = mapRowToPark(results);
            parksWithCamping.add(park);
        }
        return parksWithCamping;
    }

    @Override
    public Park getParkById(int parkId) {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping FROM park\n" +
                "WHERE park_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,parkId);
        if(results.next()){
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        return new ArrayList<>();
    }

    @Override
    public List<Park> getParksByName(String name, boolean useWildCard) {
        List<Park> parks = new ArrayList<>();
        String sql = "SELECT park_id, park_name, date_established, area, has_camping\n" +
                "FROM park\n" +
                "WHERE park_name ILIKE ?;";

        //need to swap out the string name so that is looks like this %name%
        if(useWildCard){
            name = "%"+name+"%";
        }
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        while(results.next()){ 
            Park park = mapRowToPark(results);
            parks.add(park);
        }
        return parks;
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
