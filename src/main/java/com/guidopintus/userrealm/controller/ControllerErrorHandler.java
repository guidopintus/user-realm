package com.guidopintus.userrealm.controller;

import com.guidopintus.userrealm.dto.ErrorDTO;
import com.guidopintus.userrealm.exception.DuplicateRealmNameException;
import com.guidopintus.userrealm.exception.InvalidRealmNameException;
import com.guidopintus.userrealm.exception.RealmException;
import com.guidopintus.userrealm.exception.RealmNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerErrorHandler {

    @Autowired
    private Environment env;

    @ExceptionHandler({RealmNotFoundException.class})
    public ResponseEntity<ErrorDTO> handleNotFoundException(RealmNotFoundException ex) {
        return buildResponse(ex,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DuplicateRealmNameException.class})
    public ResponseEntity<ErrorDTO> handleDuplicateRealmException(DuplicateRealmNameException ex) {
        return buildResponse(ex,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidRealmNameException.class})
    public ResponseEntity<ErrorDTO> handleInvalidRealmNameException(InvalidRealmNameException ex) {
        return buildResponse(ex,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ErrorDTO> buildResponse(RealmException ex, HttpStatus status){
        ErrorDTO errorDTO=new ErrorDTO(ex.getCode());
        return new ResponseEntity<>(errorDTO, status);
    }


}
