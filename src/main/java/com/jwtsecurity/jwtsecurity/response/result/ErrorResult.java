package com.jwtsecurity.jwtsecurity.response.result;

public class ErrorResult extends Result{
    public ErrorResult(String message) {
        super(true, message);
    }
}
