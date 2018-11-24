package com.harish.springmvc.example.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.harish.springmvc.example.domain.Client;

public class ClientRowMapper implements RowMapper<Client>{

	@Override
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client client = new Client();
		client.setId(rs.getInt("ID"));
		client.setName(rs.getString("NAME"));
		client.setEmail(rs.getString("EMAIL"));
		client.setContactNumber(rs.getString("CONTACTNUMBER"));
		
		return client;
	}

}
