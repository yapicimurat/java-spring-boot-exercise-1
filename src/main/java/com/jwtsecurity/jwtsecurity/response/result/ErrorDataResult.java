package com.jwtsecurity.jwtsecurity.response.result;

public class ErrorDataResult<T> extends DataResult<T>{

    public ErrorDataResult(T data, String message) {
        super(data, true, message);
    }
}
