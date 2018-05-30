package io.swagger.api;

import io.swagger.model.Client;
import io.swagger.repositories.ClientRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-24T21:01:11.236Z")

@Controller
public class ClientsApiController implements ClientsApi {

    private static final Logger log = LoggerFactory.getLogger(ClientsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    private ClientRepository clientRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public ClientsApiController(ObjectMapper objectMapper, HttpServletRequest request, ClientRepository clientRepository) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.clientRepository = clientRepository;

    }

    public @ResponseBody ResponseEntity<List<Client>> getAllClients() {
        String accept = request.getHeader("Accept");
        
        if (accept != null) {
            return new ResponseEntity<List<Client>>(this.clientRepository.getAll(), HttpStatus.OK);
        }
        return new ResponseEntity<List<Client>>(HttpStatus.BAD_REQUEST);
    }

    public @ResponseBody void postClient(@ApiParam(value = "Text of the client to be saved"  )  @Valid @RequestBody Client client) {
    		this.clientRepository.save(client);
    }

}
