package com.example.credit_advisory.config.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorDetails {

  String state;
  String message;
  String details;

  public static ErrorDetails build(HttpStatus status,
                                  RuntimeException exp,
                                  WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails();
    errorDetails.setState(status.getReasonPhrase());
    errorDetails.setMessage(exp.getMessage());
    errorDetails.setDetails(request.getDescription(false));
    return errorDetails;
  }

}
