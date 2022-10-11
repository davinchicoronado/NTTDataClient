package com.nttdata.client.rest.NTTDataClients.dto;

import com.nttdata.client.rest.NTTDataClients.data.Client;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ClientDto {

    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private String phone;
    private String address;
    private String cityResidence;

    public ClientDto() {
    }
    public ClientDto(Client client) {
        this.firstName = client.getFirstName();
        this.secondName = client.getSecondName();
        this.firstSurname = client.getFirstSurname();
        this.secondSurname = client.getSecondSurname();
        this.phone = client.getPhone();
        this.address = client.getAddress();
        this.cityResidence = client.getCityResidence();
    }

    public ClientDto(String firstName, String secondName, String firstSurname, String secondSurname, String phone, String address, String cityResidence) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.phone = phone;
        this.address = address;
        this.cityResidence = cityResidence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(firstName, clientDto.firstName) && Objects.equals(secondName, clientDto.secondName) && Objects.equals(firstSurname, clientDto.firstSurname) && Objects.equals(secondSurname, clientDto.secondSurname) && Objects.equals(phone, clientDto.phone) && Objects.equals(address, clientDto.address) && Objects.equals(cityResidence, clientDto.cityResidence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, firstSurname, secondSurname, phone, address, cityResidence);
    }
}
