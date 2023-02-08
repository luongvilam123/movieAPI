package com.lamluong.movieapi.exception;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException{

    String message;

    public DomainException(ErrorCode errorCode){
        message = errorCode.toString();
    }
}
