package com.harish.springmvc.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harish.springmvc.example.dao.ClientDao;
import com.harish.springmvc.example.domain.Client;

@RestController
@RequestMapping("/client")
public class ClientServiceController {
	
	@Autowired
	@Qualifier("ClientDaoDummyImpl")
	ClientDao clientDao;
	
	@RequestMapping(value="", method=RequestMethod.GET,params="!clientNumber",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Client> getClientLists() {
		List<Client> clientList = clientDao.getClientList();
		return clientList;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Client getClient(@RequestParam("clientNumber") String clientNumber) {
		Client client = clientDao.getClient(clientNumber);
		return client;
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public int createClient(@RequestBody Client client) {
		int count = clientDao.createClient(client);
		return count;
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	public int updateClient(@RequestBody Client client) {
		int count = clientDao.updateClient(client);
		return count;
	}
	
	@RequestMapping(value="", method=RequestMethod.DELETE)
	public boolean deleteClient(@RequestParam("clientNumber") String clientNumber) {
		boolean flag = clientDao.deleteClient(clientNumber);
		return flag;
	}
	
}
