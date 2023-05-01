package com.example.credit_advisory.rest;

import com.example.credit_advisory.dto.ApplicationDto;
import com.example.credit_advisory.service.ApplicationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationController {

  ApplicationService applicationService;

  @PostMapping("/application/assign/{advisorId}")
  public ResponseEntity<ApplicationDto> assignApplication(@PathVariable Integer advisorId) {
    ApplicationDto application = applicationService.assignNewApplicationToAdvisor(advisorId);
    return ResponseEntity.ok(application);
  }
}
