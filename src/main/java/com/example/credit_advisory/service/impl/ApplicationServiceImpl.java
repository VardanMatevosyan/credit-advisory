package com.example.credit_advisory.service.impl;

import static com.example.credit_advisory.constant.ErrorMessage.ADVISORS_APP_NOT_FOUND_MSG;
import static com.example.credit_advisory.constant.ErrorMessage.ADVISOR_NOT_FOUND_MSG;

import com.example.credit_advisory.dto.ApplicationDto;
import com.example.credit_advisory.entity.Advisor;
import com.example.credit_advisory.entity.Application;
import com.example.credit_advisory.mapper.ApplicationMapper;
import com.example.credit_advisory.repository.AdvisorRepository;
import com.example.credit_advisory.repository.ApplicationRepository;
import com.example.credit_advisory.service.ApplicationService;
import java.util.NoSuchElementException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationServiceImpl implements ApplicationService {

  ApplicationRepository applicationRepository;
  AdvisorRepository advisorRepository;
  ApplicationMapper applicationMapper;

  @Override
  @Transactional
  public ApplicationDto assignNewApplicationToAdvisor(Integer advisorId) {
    var advisor = findAdvisor(advisorId);
    var application = findApplication(advisor);
    advisor.assignApplication(application);
    return applicationMapper.toDto(application);
  }

  private Application findApplication(Advisor advisor) {
    return applicationRepository
        .findFirstNewByAmountInRange(advisor.getMinAmount(), advisor.getMaxAmount())
        .orElseThrow(() ->
            new NoSuchElementException(ADVISORS_APP_NOT_FOUND_MSG.formatted(advisor.getId())));
  }

  private Advisor findAdvisor(Integer id) {
    return advisorRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException(ADVISOR_NOT_FOUND_MSG.formatted(id)));
  }
}
