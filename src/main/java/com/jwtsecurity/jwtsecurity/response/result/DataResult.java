package com.jwtsecurity.jwtsecurity.response.result;

public abstract class DataResult<T> extends Result{
    public T data;

    public DataResult(T data, Boolean error, String message){
        super(error, message);
        this.data = data;
    }
}
