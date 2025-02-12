package com.se.exception;


import com.se.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorMessage> handlerResourceNotFound(ResourceNotFoundException exc) {

  ErrorMessage err = new ErrorMessage();

  err.setStatus(HttpStatus.NOT_FOUND.value());
  err.setMsg(exc.getMessage());
  err.setTimestamp(new Date());

   return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorMessage> handlerInvalidArgument(MethodArgumentNotValidException exc) {

      Map<String, String> err = new HashMap<>();

        exc.getBindingResult().getFieldErrors().forEach(error -> {
          err.put(error.getField(), error.getDefaultMessage());
        });

      return new ResponseEntity<>(new ErrorMessage(400, err, new Date()), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ErrorMessage> handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exc) {
    ErrorMessage err = new ErrorMessage();

    err.setMsg(exc.getMessage());
    err.setStatus(HttpStatus.BAD_REQUEST.value());
    err.setTimestamp(new Date());


    return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

  }

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<ErrorMessage> handlerRestUrlNotFoundException(NoHandlerFoundException exc) {

    ErrorMessage err = new ErrorMessage();

    err.setMsg("Endpoint named " + exc.getRequestURL() + " with method: " + exc.getHttpMethod() + " does not exist");
    err.setStatus(404);
    err.setTimestamp(new Date());


    return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
  }

}

