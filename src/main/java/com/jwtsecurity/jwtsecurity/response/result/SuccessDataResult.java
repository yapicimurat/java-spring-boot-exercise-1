package com.jwtsecurity.jwtsecurity.response.result;

public class SuccessDataResult<T> extends DataResult<T>{

    public SuccessDataResult(T data, String message) {
        super(data, false, message);
    }
}
