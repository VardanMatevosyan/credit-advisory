package com.example.credit_advisory.config.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
public class ControllerExceptionAdvise {

  @ExceptionHandler(value = {RuntimeException.class})
  public ResponseEntity<ErrorDetails> handleBadRequest(RuntimeException e, WebRequest webRequest) {
    log.error(e.getMessage() + " from " + webRequest.getDescription(false));
    ErrorDetails errorDetails = ErrorDetails.build(BAD_REQUEST, e, webRequest);
    return ResponseEntity.badRequest().body(errorDetails);
  }

}
