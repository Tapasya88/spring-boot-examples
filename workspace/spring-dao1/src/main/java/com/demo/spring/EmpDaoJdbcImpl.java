package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmpDaoJdbcImpl implements EmpDao {

	@Autowired
	JdbcTemplate jt;

	@Override
	@Transactional
	public String save(Emp e) {
		int rowCount = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pst = conn
						.prepareStatement("insert into emp(empno,name,address,salary) values (?,?,?,?)");
				pst.setInt(1, e.getEmpId());
				pst.setString(2, e.getName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, e.getSalary());
				return pst;
			}

		});
		if (rowCount == 1)
			return "Data Saved";
		return "Data not saved";
	}

	@Override
	public List<Emp> getAllEmps() {
		List<Emp> empList = jt.query("select * from emp", new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int index) throws SQLException {
				// TODO Auto-generated method stub
				return new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}

		});
		return empList;
	}

	@Override
	public String delete(int id) {
		int rowCount = jt.update("delete from emp where id=" + id);
		if (rowCount == 1)
			return "Data Deleted";
		return "Data not Deleted";
		
	}

	@Override
	public Emp findById(int id) {
		Emp e = jt.queryForObject("select * from emp where empno=" + id, new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int index) throws SQLException {
				// TODO Auto-generated method stub
				return new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
		});
		return e;
	}

}
