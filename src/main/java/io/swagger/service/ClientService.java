package io.swagger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.Client;
import io.swagger.model.ClientAction;
import io.swagger.repositories.ClientRepository;

@Service
public class ClientService {
	
	
	private ClientRepository clientRepository;
	
	@Autowired 
	public ClientService(ClientRepository clientRepositoryImpl){
		this.clientRepository = clientRepositoryImpl;
	}
	
	//operation on users
	
	public Client findClientById(String clientId){
		return this.clientRepository.findById(clientId);
	}
	

	//operations on user actions
	
	public void deleteActionById(String clientId, String actionId){
		Client client = findClientById(clientId);
		client.getActions().remove(actionId);
		this.clientRepository.save(client);
	}
	
	public ClientAction getActionById(String clientId, String actionId){
		Client client = findClientById(clientId);
		return client.getActions().get(actionId);
	}
	
	public void addActionToClient(String clientId, ClientAction action) {
		Client client = findClientById(clientId);
		if (action.getId() == null || action.getId().trim().length() == 0) {
			String keys[] = client.getActions().keySet().toArray(new String[0]);
			Arrays.sort(keys);
			Arrays.sort(keys);
			//System.out.print("The key of the action to be saved is: " + action.getId());
			//System.out.println("The largest key of action is: " + Integer.parseInt(keys[keys.length - 1]));
			if(keys.length >= 1)
				action.setId(Integer.parseInt(keys[keys.length - 1]) + 1 + "");
			else
				action.setId("1");
		}
		client.getActions().put(action.getId(), action);
		this.clientRepository.save(client);
	}

	public void addBatchActionsToClient(String clientId, List<ClientAction> actions) {
		final Client client = findClientById(clientId);
		actions.forEach(action -> {
			if (action.getId() == null || action.getId().trim().length() == 0) {
				String keys[] = client.getActions().keySet().toArray(new String[0]);
				Arrays.sort(keys);
				//System.out.print("The key of the action to be saved is: " + action.getId());
				//System.out.println("The largest key of action is: " + Integer.parseInt(keys[keys.length - 1]));
				if(keys.length >= 1)
					action.setId(Integer.parseInt(keys[keys.length - 1]) + 1 + "");
				else
					action.setId("1");
			}
			client.getActions().put(action.getId(), action);
		});
		this.clientRepository.save(client);
	}

	public ArrayList<ClientAction> getAllActions(String clientId) {
		Client client = findClientById(clientId);
		ArrayList<ClientAction> actions = new ArrayList<ClientAction>(client.getActions().values());
		return actions;
	}

	public void deleteAllActions(String clientId) {
		Client client = findClientById(clientId);
		client.setActions(new HashMap<String, ClientAction>());
		this.clientRepository.save(client);
	}
	
	
	
}
