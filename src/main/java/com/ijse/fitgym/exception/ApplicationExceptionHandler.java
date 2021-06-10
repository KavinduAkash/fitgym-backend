package com.ijse.fitgym.exception;

import com.ijse.fitgym.dto.json.response.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {FitGymServiceException.class})
    public ResponseEntity handleFitGymServiceException(FitGymServiceException ex, WebRequest webRequest) {
        return new ResponseEntity<>(new ErrorMessageDTO(ex.getStatus(), false, ex.getMessage()), HttpStatus.OK);
    }

}
