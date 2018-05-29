package io.swagger.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.google.common.annotations.Beta;

import io.swagger.model.Client;


@Repository
public class ClientRepositoryImpl implements ClientRepository{
	
	
	private RedisTemplate<String, Client> redisTemplate;
	
	private HashOperations hashOperations;
	//private ValueOperations valueOperations;
	
	
	@Autowired
	public ClientRepositoryImpl(RedisTemplate<String, Client> redisTemplate){
		this.redisTemplate = redisTemplate;
		//this.valueOperations = redisTemplate.opsForValue();
		this.hashOperations = redisTemplate.opsForHash();
	}

	
	@SuppressWarnings("unchecked")
	public Client findById(String id) {	
		System.out.println("This is from get /client/uuid: The id of client to get is:" + id);
		return (Client) this.hashOperations.get("CLIENT", id);
		//System.out.println("This is from get /client/uuid: The client to be retrived:" + a.getUuid() + "----" + a.getFirstName() + "----" + a.getLastName());
	}

	@SuppressWarnings("unchecked")
	public Client save(Client client) {
		System.out.println("This is from POST /clients: The client to be saved is:" + client.toString());
		this.hashOperations.put("CLIENT", client.getUuid(), client);
		return client;
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> getAll(){
		return this.hashOperations.values("CLIENT");
	}
	
	
	public void update(Client client){
		save(client);
	}

}
