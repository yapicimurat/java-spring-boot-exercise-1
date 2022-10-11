package com.jwtsecurity.jwtsecurity.response.result;

public class SuccessResult extends Result{

    public SuccessResult(String message) {
        super(false, message);
    }
}
