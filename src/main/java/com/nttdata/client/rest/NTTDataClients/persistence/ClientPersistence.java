package com.nttdata.client.rest.NTTDataClients.persistence;

import com.nttdata.client.rest.NTTDataClients.data.Client;
import com.nttdata.client.rest.NTTDataClients.persistence.exceptions.PersistenceDataException;
import com.nttdata.client.rest.NTTDataClients.persistence.exceptions.PersistenceNotFoundException;

public interface ClientPersistence {

    Client getClient(String id, String type) throws PersistenceNotFoundException, PersistenceDataException;
}
