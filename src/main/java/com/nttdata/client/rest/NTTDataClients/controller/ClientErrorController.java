package com.nttdata.client.rest.NTTDataClients.controller;


import com.nttdata.client.rest.NTTDataClients.dto.ErrorDto;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ClientErrorController implements ErrorController {

    @RequestMapping("/error")
    public ErrorDto handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            Exception exception = (Exception) request.getAttribute("org.springframework.web.servlet.DispatcherServlet.EXCEPTION");
            if(exception != null){
                return new ErrorDto(statusCode, exception.getMessage());
            }
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return new ErrorDto(statusCode,"Service not Found");
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return new ErrorDto(statusCode,"Internal Error");
            }

        }
        return new ErrorDto();
    }


}
