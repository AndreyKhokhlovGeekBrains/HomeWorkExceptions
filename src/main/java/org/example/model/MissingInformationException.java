package org.example.model;

public class MissingInformationException extends RuntimeException{
    private ValidationError errorCode;
    public MissingInformationException(ValidationError errorCode){
        super("Missing information for field " + errorCode.name());
        this.errorCode = errorCode;
    }

    public ValidationError getErrorCode(){
        return errorCode;
    }
}
