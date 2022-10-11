package com.nttdata.client.rest.NTTDataClients.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {

    private Integer status;
    private String message;

    public ErrorDto(){

    }
    public ErrorDto(Integer statusCode, String message) {
        this.status  = statusCode;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
