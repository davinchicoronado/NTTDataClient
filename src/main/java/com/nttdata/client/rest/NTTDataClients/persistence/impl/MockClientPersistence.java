package com.nttdata.client.rest.NTTDataClients.persistence.impl;

import com.nttdata.client.rest.NTTDataClients.data.Client;
import com.nttdata.client.rest.NTTDataClients.data.TypeDocument;
import com.nttdata.client.rest.NTTDataClients.persistence.ClientPersistence;
import com.nttdata.client.rest.NTTDataClients.persistence.exceptions.PersistenceDataException;
import com.nttdata.client.rest.NTTDataClients.persistence.exceptions.PersistenceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
@Qualifier("mockPersistence")
@ImportResource("classpath:beans.xml")
public class MockClientPersistence implements ClientPersistence {

    @Autowired
    @Resource(name="clientsNTTData")
    private Map<String,Client> clients;
    @Override
    public Client getClient(String id, String type) throws PersistenceNotFoundException, PersistenceDataException {
        try{
            Client client = clients.get(id+TypeDocument.valueOf(type));
            if(client == null){
                throw new PersistenceNotFoundException("The next client does not exist: "+ id + " with document type: "+type);
            }
            return client;
        }catch (IllegalArgumentException ex){
            throw new PersistenceDataException("Data error");
        }

    }

}
