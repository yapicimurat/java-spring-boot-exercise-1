package com.jwtsecurity.jwtsecurity.response.result;

public abstract class Result {

    public Boolean error;
    public String message;

    public Result(Boolean error, String message){
        this.error = error;
        this.message = message;
    }

}
