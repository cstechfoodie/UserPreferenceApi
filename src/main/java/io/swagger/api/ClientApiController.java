package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.model.Client;
import io.swagger.model.ClientAction;
import io.swagger.repositories.ClientRepository;
import io.swagger.repositories.ClientRepositoryImpl;
import io.swagger.service.ClientService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-24T21:01:11.236Z")

@Controller
public class ClientApiController implements ClientApi {
	
	private ClientService clientService;

    private static final Logger log = LoggerFactory.getLogger(ClientApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ClientApiController(ObjectMapper objectMapper, HttpServletRequest request, ClientService clientService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.clientService = clientService;
    }

    public @ResponseBody ResponseEntity<Client> getClientById(@ApiParam(value = "unique identifier of the client",required=true) @PathVariable("uuid") String uuid) {
        try{
        	Client oneClient = this.clientService.findClientById(uuid);
            if(oneClient != null){
            	return new ResponseEntity<Client>(oneClient, HttpStatus.OK);
            }
            else{
            	oneClient = null;
            	return new ResponseEntity<Client>(oneClient, HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e){
        	return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    	 
    }
    
    public @ResponseBody ResponseEntity<Void> addActionToClient(@ApiParam(value = "unique identifier of the client",required=true) @PathVariable("uuid") String uuid, @ApiParam(value = "Text of the clientAction to be saved"  )  @Valid @RequestBody ClientAction action) {
    	String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	this.clientService.addActionToClient(uuid, action);
            	return new ResponseEntity<Void>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else{
        	return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
        }
	}

	
	public @ResponseBody ResponseEntity<ClientAction> getActionById(@ApiParam(value = "unique identifier of the client",required=true) @PathVariable("uuid") String uuid,@ApiParam(value = "unique identifier of the action",required=true) @PathVariable("id") String id) {
		try{
			ClientAction action = this.clientService.getActionById(uuid, id);
			if (action != null) {
				return new ResponseEntity<ClientAction>(action, HttpStatus.OK);
			} else {
				return new ResponseEntity<ClientAction>(HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e){
			return new ResponseEntity<ClientAction>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public @ResponseBody ResponseEntity<Void> deleteActionById(
			@ApiParam(value = "unique identifier of the client", required = true) @PathVariable("uuid") String uuid,
			@ApiParam(value = "unique identifier of the action", required = true) @PathVariable("id") String id) {
		try {
			this.clientService.deleteActionById(uuid, id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	};

	public @ResponseBody ResponseEntity<ArrayList<ClientAction>> getAllActions(@ApiParam(value = "unique identifier of the client",required=true) @PathVariable("uuid") String uuid) {
		try{
		ArrayList<ClientAction> actions = this.clientService.getAllActions(uuid);
		return new ResponseEntity<ArrayList<ClientAction>>(actions, HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<ArrayList<ClientAction>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public @ResponseBody ResponseEntity<Void> addBatchActionsToClient(@ApiParam(value = "unique identifier of the client",required=true) @PathVariable("uuid") String uuid, @ApiParam(value = "Text of the clientAction to be saved"  )  @Valid @RequestBody List<ClientAction> actions){
		String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	this.clientService.addBatchActionsToClient(uuid, actions);
            	return new ResponseEntity<Void>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else{
        	return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
        }
	};
	
	public @ResponseBody ResponseEntity<Void> deleteAllActions(
			@ApiParam(value = "unique identifier of the client", required = true) @PathVariable("uuid") String uuid) {

		try {
			this.clientService.deleteAllActions(uuid);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	};
}
