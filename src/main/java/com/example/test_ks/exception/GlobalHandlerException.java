package com.example.test_ks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalHandlerException {

    public ResponseEntity<ErrorResponse> createError(HttpStatus httpStatus, Exception e, HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok().body(ErrorResponse
                .builder()
                .httpStatus(httpStatus)
                .reason(e.getMessage())
                .path(httpServletRequest.getRequestURI())
                .build());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handlerNotFoundException(NotFoundException e, HttpServletRequest httpServletRequest) {
        return createError(HttpStatus.NOT_FOUND, e, httpServletRequest);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handlerBadRequestException(BadRequestException e, HttpServletRequest httpServletRequest) {
        return createError(HttpStatus.BAD_REQUEST, e, httpServletRequest);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorResponse> handlerDuplicateResourceException(DuplicateResourceException e, HttpServletRequest httpServletRequest) {
        return createError(HttpStatus.CONFLICT, e, httpServletRequest);
    }

    @ExceptionHandler(UnAuthorizationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorResponse> handlerUnAuthorizationException(UnAuthorizationException e, HttpServletRequest httpServletRequest) {
        return createError(HttpStatus.CONFLICT, e, httpServletRequest);
    }

    @ExceptionHandler(TokenException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorResponse> handlerTokenException(TokenException e, HttpServletRequest httpServletRequest) {
        return createError(HttpStatus.CONFLICT, e, httpServletRequest);
    }

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handlerAlreadyExistException(AlreadyExistException e, HttpServletRequest httpServletRequest) {
        return createError(HttpStatus.BAD_REQUEST, e, httpServletRequest);
    }
}
