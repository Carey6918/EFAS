package com.example.demo.util;

public class ResultBundle<T> {

    public boolean isSuccess;

    public String errorInfo;

    public T object;

    public ResultBundle(T object) {
        this.object = object;
    }
    public ResultBundle(boolean isSuccess,String errorInfo) {
        this.isSuccess=isSuccess;
        this.errorInfo=errorInfo;
    }

}
