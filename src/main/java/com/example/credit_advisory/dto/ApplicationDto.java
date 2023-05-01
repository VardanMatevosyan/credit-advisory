package com.example.credit_advisory.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {

  BigDecimal amount;
  String status;
  ApplicantDto applicantDto;
  AdvisorDto advisorDto;

}
