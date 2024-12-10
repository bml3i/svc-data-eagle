package blog.leobi.dataeagle.controller;

import blog.leobi.dataeagle.dto.CustomError;
import blog.leobi.dataeagle.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleException(Exception e) {
        return ResponseEntity.ok(
                new ResponseDTO().buildErrorMessage(
                        new CustomError(String.valueOf(HttpStatus.BAD_REQUEST.value()), e.getMessage())
                )
        );
    }

}
