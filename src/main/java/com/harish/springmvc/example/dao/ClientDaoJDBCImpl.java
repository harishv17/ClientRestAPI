package com.harish.springmvc.example.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.harish.springmvc.example.domain.Client;
import com.harish.springmvc.example.util.ClientConstant;
import com.harish.springmvc.example.util.ClientRowMapper;

@Repository
public class ClientDaoJDBCImpl implements ClientDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Client> getClientList() {
		List<Client> clientList = namedParameterJdbcTemplate.query(ClientConstant.SELECT_CLIENT_LIST_QUERY, new ClientRowMapper());
		return clientList;
	}

	@Override
	public Client getClient(String clientNumber) {
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("ID", clientNumber);
		Client client = namedParameterJdbcTemplate.queryForObject(ClientConstant.SELECT_CLIENT_QUERY, paramMap, new ClientRowMapper());
		return client;
	}

	@Override
	public int createClient(Client client) {
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("ID", Integer.toString(client.getId()));
		paramMap.put("NAME", client.getName());
		paramMap.put("CONTACTNUMBER", client.getContactNumber());
		paramMap.put("EMAIL", client.getEmail());
		int count = namedParameterJdbcTemplate.update(ClientConstant.CREATE_CLIENT_QUERY, paramMap);
		return count;
	}

	@Override
	public int updateClient(Client client) {
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("ID", Integer.toString(client.getId()));
		paramMap.put("NAME", client.getName());
		paramMap.put("CONTACTNUMBER", client.getContactNumber());
		paramMap.put("EMAIL", client.getEmail());
		int count = namedParameterJdbcTemplate.update(ClientConstant.UPDATE_CLIENT_QUERY, paramMap);
		return count;
	}

	@Override
	public boolean deleteClient(String clientNumber) {
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("ID", clientNumber);
		int count = namedParameterJdbcTemplate.update(ClientConstant.DELETE_CLIENT_QUERY, paramMap);
		return count>0;
	}

}
