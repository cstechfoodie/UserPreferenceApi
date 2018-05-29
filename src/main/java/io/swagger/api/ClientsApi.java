/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.model.Client;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-24T21:01:11.236Z")

@Api(value = "clients", description = "the clients API")
public interface ClientsApi {

    @ApiOperation(value = "", nickname = "getAllClients", notes = "", response = Client.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of clients", response = Client.class, responseContainer = "List") })
    @RequestMapping(value = "/clients",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Client>> getAllClients();


    @ApiOperation(value = "", nickname = "postClient", notes = "Create a new client", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Successfully create a new client") })
    @RequestMapping(value = "/clients",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    void postClient(@ApiParam(value = "Text of the client to be saved"  )  @Valid @RequestBody Client client);

}