package com.nttdata.client.rest.NTTDataClients.persistence.exceptions;

public class PersistenceNotFoundException extends Exception{

    public PersistenceNotFoundException(String message) {
        super(message);
    }

    public PersistenceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
