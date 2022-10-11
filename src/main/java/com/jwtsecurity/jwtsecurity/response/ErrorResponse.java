package com.jwtsecurity.jwtsecurity.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private int statusCode;

    private String message;

    private String path;

    public ErrorResponse(String message){
        super();
        this.message = message;
    }


}
