package io.swagger.repositories;


import java.util.List;

import io.swagger.model.Client; 


public interface ClientRepository{
	
	public Client findById(String id);
	
	public Client save(Client client);
	
	public List<Client> getAll();
	
	public void update(Client client);
	
	
}
