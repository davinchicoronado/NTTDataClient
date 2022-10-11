package com.nttdata.client.rest.NTTDataClients.service.impl;

import com.nttdata.client.rest.NTTDataClients.data.Client;
import com.nttdata.client.rest.NTTDataClients.persistence.ClientPersistence;
import com.nttdata.client.rest.NTTDataClients.persistence.exceptions.PersistenceDataException;
import com.nttdata.client.rest.NTTDataClients.service.ClientService;
import com.nttdata.client.rest.NTTDataClients.persistence.exceptions.PersistenceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ImpClientService implements ClientService {

    @Autowired
    @Qualifier("mockPersistence")
    ClientPersistence clientPersistence;

    @Override
    public Client find(String id, String type) throws PersistenceNotFoundException, PersistenceDataException {
            return clientPersistence.getClient(id,type);

    }
}
