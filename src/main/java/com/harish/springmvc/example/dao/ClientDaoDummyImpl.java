package com.harish.springmvc.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.harish.springmvc.example.domain.Client;

@Repository("ClientDaoDummyImpl")
public class ClientDaoDummyImpl implements ClientDao {

	public static List<Client> clientList = new ArrayList<>();
	static {
		clientList.add(new Client(1, "Harish", "123", "abc@def.com"));
		clientList.add(new Client(2, "XYZ", "456", "awe@def.com"));
	}

	@Override
	public List<Client> getClientList() {
		return clientList;
	}

	@Override
	public Client getClient(String clientNumber) {
		Client client = clientList.stream().filter(a -> a.getId() == Integer.parseInt(clientNumber)).findAny()
				.orElse(null);
		return client;
	}

	@Override
	public int createClient(Client client) {
		clientList.add(client);
		return 1;
	}

	@Override
	public int updateClient(Client client) {
		long i = clientList.stream().map(c -> {
			if (c.getId() == client.getId())
				c = client;
			return c;
		}).count();
		/*
		 * int i = IntStream.range(0, clientList.size()).filter(index ->
		 * clientList.get(index).getId() == client.getId()) .findFirst().getAsInt();
		 * clientList.set(i, client);
		 */
		return (int)i;
	}

	@Override
	public boolean deleteClient(String clientNumber) {
		boolean flag = clientList.removeIf(client -> client.getId() == Integer.parseInt(clientNumber));
		return flag;
	}

}
