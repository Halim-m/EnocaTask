package com.enoca.crud.common;

public class ServiceResult<T> {
    private T data;
    private boolean success;
    private String errorMessage;

    public ServiceResult(T data, boolean success, String errorMessage){
        this.data = data;
        this.errorMessage = errorMessage;
        this.success = success;
    }

    public ServiceResult(){

    }

    public T getData(){
        return data;
    }
    public void setData(){
        this.data = data;
    }

    public boolean isSuccess(){
        return success;
    }
    public void setSuccess(){
        this.success = success;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
    public void  setErrorMessage(){
        this.errorMessage = errorMessage;
    }
}
