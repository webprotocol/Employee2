package com.hybrid.mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hybrid.model.Member;

public class MemberMapperTest {

	static Log log = LogFactory.getLog(MemberMapperTest.class);
	
	public static void main(String[] args) throws SQLException {
		
		String driverClassName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/world";
		String username="root";
		String password="mysql";
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		printMembers(dataSource.getConnection());
		
		log.info("Program exit...");

	}
	
	static void printMembers(Connection con) throws SQLException {
		String sql = "select * from member";
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		List<Member> list = new ArrayList<>();
		
		while(rs.next()) {
			// Object Relational Mapping(ORM)
			Member m = new Member();
			m.setId(rs.getLong("id"));
			m.setEmail(rs.getString("email"));
			m.setName(rs.getString("name"));
			m.setPassword(rs.getString("password"));
			m.setRegisterDate(rs.getDate("register_date"));
			
			list.add(m);
		}
		
		for (Member m : list) {
			log.info("id = " + m.getId());
			log.info("email = " + m.getEmail());
			log.info("name = " + m.getName());
			log.info("password = " + m.getPassword());
			log.info("registerDate = " + m.getRegisterDate());
		}
		
		
	}
	
	
	

}
