package com.nttdata.client.rest.NTTDataClients.persistence.exceptions;

public class PersistenceDataException extends Exception{

    public PersistenceDataException(String message) {
        super(message);
    }

    public PersistenceDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
