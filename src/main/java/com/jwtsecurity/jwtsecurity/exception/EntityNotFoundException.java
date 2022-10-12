package com.jwtsecurity.jwtsecurity.exception;

import com.jwtsecurity.jwtsecurity.consts.exception.ExceptionMessages;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Data
public class EntityNotFoundException extends RuntimeException {

    private final HttpStatus status = HttpStatus.NOT_FOUND;
    private String message = ExceptionMessages.NOT_FOUND;
    private final LocalDateTime localDateTime = LocalDateTime.now();

    public EntityNotFoundException(){}

    public EntityNotFoundException(String message){
        this.message = message;
    }
}
