package com.jwtsecurity.jwtsecurity.exception;

import com.jwtsecurity.jwtsecurity.consts.exception.ExceptionMessages;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class EntityAlreadyExistException extends RuntimeException{

    private final String message = ExceptionMessages.ALREADY_EXIST;
    private final String path;
    private final LocalDateTime localDateTime = LocalDateTime.now();
    private final HttpStatus status = HttpStatus.BAD_REQUEST;


    public EntityAlreadyExistException(String path) {
        this.path = path;
    }

}
