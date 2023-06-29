package com.mongodbtraining.mongotraining.services.exception;

public class ObjectNotFoundException extends RuntimeException{
    private static final Long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
