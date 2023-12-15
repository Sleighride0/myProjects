package com.techelevator.movies.dao;

import com.techelevator.movies.model.Movie;
import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT person_id, person_name, birthday, deathday, biography, profile_path, home_page FROM person";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            persons.add(mapRowToPerson(results));
        }
        return persons;
    }

    @Override
    public Person getPersonById(int id) {
        Person person = null;
        String sql = "SELECT person_id, person_name, birthday, deathday, biography, profile_path, home_page FROM person WHERE person_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            person = mapRowToPerson(results);
        }
        return person;
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT * FROM person WHERE person_name ILIKE ?;";
        if(useWildCard){
            name = "%"+name+"%";
        }
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        while (results.next()) {
            persons.add(mapRowToPerson(results));
        }
        return persons;
    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT person_id, person_name, birthday, deathday, biography, profile_path, person.home_page\n" +
                "FROM movie\n" +
                "JOIN collection ON collection.collection_id = movie.collection_id\n" +
                "JOIN movie_actor ON movie.movie_id = movie_actor.movie_id\n" +
                "JOIN person ON movie_actor.actor_id = person.person_id\n" +
                "WHERE collection_name ILIKE ?;";
        if(useWildCard){
            collectionName = "%"+collectionName+"%";
        }
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionName);
        while (results.next()) {
            persons.add(mapRowToPerson(results));
        }
        return persons;
    }
    private Person mapRowToPerson(SqlRowSet rowSet) {
        Person person = new Person();
        person.setId(rowSet.getInt("person_id"));
        person.setName(rowSet.getString("person_name"));
        if (rowSet.getDate("birthday") != null) {
            person.setBirthday(rowSet.getDate("birthday").toLocalDate());
        }
        if (rowSet.getDate("deathday") != null) {
            person.setDeathDate(rowSet.getDate("deathday").toLocalDate());
        }
        person.setBiography(rowSet.getString("biography"));
        person.setProfilePath(rowSet.getString("profile_path"));
        person.setHomePage(rowSet.getString("home_page"));
        return person;
    }
}
