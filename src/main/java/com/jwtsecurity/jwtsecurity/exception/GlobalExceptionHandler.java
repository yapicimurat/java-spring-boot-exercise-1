package com.jwtsecurity.jwtsecurity.exception;

import com.jwtsecurity.jwtsecurity.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleEntityNotFoundException(EntityNotFoundException entityNotFoundException, HttpServletRequest httpRequest){
        return new ErrorResponse(entityNotFoundException.getStatus().value(), entityNotFoundException.getMessage(), httpRequest.getServletPath());
    }


    @ExceptionHandler(value = EntityAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleEntityAlreadyExistException(EntityAlreadyExistException entityAlreadyExistException, HttpServletRequest httpRequest){
        return new ErrorResponse(entityAlreadyExistException.getStatus().value(), entityAlreadyExistException.getMessage(), httpRequest.getServletPath());
    }

    @ExceptionHandler(value = HttpServerErrorException.InternalServerError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleInternalServerErrorException(HttpServerErrorException.InternalServerError internalServerError, HttpServletRequest httpRequest){
        return new ErrorResponse(internalServerError.getStatusCode().value(), internalServerError.getMessage(), httpRequest.getServletPath());
    }


}
