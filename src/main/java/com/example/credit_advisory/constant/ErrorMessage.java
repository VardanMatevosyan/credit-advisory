package com.example.credit_advisory.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorMessage {

  public static final String ADVISOR_NOT_FOUND_MSG = "Advisor with id %s doesn't exist";
  public static final String ADVISORS_APP_NOT_FOUND_MSG = "No application found for advisor id %s ";
}
