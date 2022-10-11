package com.nttdata.client.rest.NTTDataClients.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {

    private String id;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private String phone;
    private String address;
    private String cityResidence;

    private TypeDocument typeDocument;

    public Client() {
    }

    public Client(String id, String firstName, String secondName, String firstSurname, String secondSurname, String phone, String address, String cityResidence, TypeDocument typeDocument) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.phone = phone;
        this.address = address;
        this.cityResidence = cityResidence;
        this.typeDocument = typeDocument;
    }
}
