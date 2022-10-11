package com.nttdata.client.rest.NTTDataClients.service;

import com.nttdata.client.rest.NTTDataClients.data.Client;
import com.nttdata.client.rest.NTTDataClients.persistence.exceptions.PersistenceDataException;
import com.nttdata.client.rest.NTTDataClients.persistence.exceptions.PersistenceNotFoundException;

public interface ClientService {

    Client find(String id, String type) throws PersistenceNotFoundException, PersistenceDataException;

}
