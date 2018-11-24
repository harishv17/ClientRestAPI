package com.harish.springmvc.example.dao;

import java.util.List;

import com.harish.springmvc.example.domain.Client;

public interface ClientDao {
	
	public List<Client> getClientList();
	public Client getClient(String clientNumber);
	public int createClient(Client client);
	public int updateClient(Client client);
	public boolean deleteClient(String clientNumber);
}
