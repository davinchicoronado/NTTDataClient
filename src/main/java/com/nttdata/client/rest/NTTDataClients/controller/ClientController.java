package com.nttdata.client.rest.NTTDataClients.controller;

import com.nttdata.client.rest.NTTDataClients.dto.ClientDto;
import com.nttdata.client.rest.NTTDataClients.persistence.exceptions.PersistenceDataException;
import com.nttdata.client.rest.NTTDataClients.persistence.exceptions.PersistenceNotFoundException;
import com.nttdata.client.rest.NTTDataClients.service.ClientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping( "/v1/client" )
@Log4j2
public class ClientController {

    private final ClientService clientService;

    public ClientController(@Autowired ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("id/{id}/type-document/{type}")
    public ResponseEntity<ClientDto> findById(@PathVariable("id") String id, @PathVariable("type") String type)
    {
        try{
            log.info("Queried consulted with id :"+ id);
            return new ResponseEntity<>(new ClientDto(clientService.find(id,type)),HttpStatus.ACCEPTED);
        }catch (PersistenceNotFoundException ex){
            log.error("Provide correct Client id and type");
            throw new ResponseStatusException(HttpStatus.ACCEPTED,"Provide correct Client id and type",ex);
        }catch (PersistenceDataException ex){
            log.error("Incorrect, error data");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Incorrect",ex);
        }
    }

}
