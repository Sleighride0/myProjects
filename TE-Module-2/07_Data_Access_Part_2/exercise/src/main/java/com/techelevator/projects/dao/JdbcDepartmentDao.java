package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {

	private final String DEPARTMENT_SELECT = "SELECT d.department_id, d.name FROM department d ";
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartmentById(int id) {
		Department department = null;
		String sql = DEPARTMENT_SELECT +
				" WHERE d.department_id=?";
		try{
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if (results.next()) {
			department = mapRowToDepartment(results);
		}

		}catch(CannotGetJdbcConnectionException e){
			throw new DaoException("Couldn't connect to database. Please contact someone who cares.", e);
		} catch (DataIntegrityViolationException e){
			throw new DaoException("What are you thinking!?! Not cool.", e);
		}
		return department;
	}

	@Override
	public List<Department> getDepartments() {
		List<Department> departments = new ArrayList<>();
		String sql = DEPARTMENT_SELECT;
		try{
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			departments.add(mapRowToDepartment(results));
		}
		}catch(CannotGetJdbcConnectionException e){
			throw new DaoException("Couldn't connect to database. Please contact someone who cares.", e);
		} catch (DataIntegrityViolationException e){
			throw new DaoException("What are you thinking!?! Not cool.", e);
		}
		return departments;
	}

	@Override
	public Department createDepartment(Department department) {
		String sql = "INSERT INTO department (name)\n" +
				"VALUES  (?) RETURNING department_id;";
		try {
			int deptID = jdbcTemplate.queryForObject(sql, int.class, department.getName());
			department.setId(deptID);
		}catch(CannotGetJdbcConnectionException e){
			throw new DaoException("Couldn't connect to database. Please contact someone who cares.", e);
		} catch (DataIntegrityViolationException e){
			throw new DaoException("What are you thinking!?! Not cool.", e);
		}
		return department;
	}

	@Override
	public Department updateDepartment(Department department) {
		String sql = "UPDATE department SET  name = ?\n" +
				"WHERE department_id = ?;";
		try {
			int numberOfRows = jdbcTemplate.update(sql, department.getName(),department.getId());

			if (numberOfRows == 0) {
				throw new DaoException("Zero rows affected");
			}

		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Unable to connect to server or database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation", e);
		}
		return department;
	}

	@Override
	public int deleteDepartmentById(int id) {
		int numberOfRows = 0;
		String sqt = "UPDATE employee SET department_id = 0\n" +
				"WHERE department_id = ?;";
		String sql = "DELETE FROM department WHERE department_id = ?;";
		try {
			jdbcTemplate.update(sqt, id);
			numberOfRows = jdbcTemplate.update(sql, id);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Unable to connect to server or database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation", e);
		}
		return numberOfRows;
	}

	private Department mapRowToDepartment(SqlRowSet results) {
		Department department = new Department();
		department.setId(results.getInt("department_id"));
		department.setName(results.getString("name"));
		return department;
	}

}
