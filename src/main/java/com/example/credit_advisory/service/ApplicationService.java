package com.example.credit_advisory.service;

import com.example.credit_advisory.dto.ApplicationDto;

public interface ApplicationService {

  ApplicationDto assignNewApplicationToAdvisor(Integer advisorId);

}
