package com.example.credit_advisory.mapper;

import com.example.credit_advisory.dto.AdvisorDto;
import com.example.credit_advisory.dto.ApplicantDto;
import com.example.credit_advisory.dto.ApplicationDto;
import com.example.credit_advisory.entity.Advisor;
import com.example.credit_advisory.entity.Applicant;
import com.example.credit_advisory.entity.Application;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {ApplicantMapper.class, AdvisorMapper.class}
)
public abstract class ApplicationMapper {

  @Autowired
  ApplicantMapper applicantMapper;
  @Autowired
  AdvisorMapper advisorMapper;

  @Mapping(target = "applicantDto", source = "applicant", qualifiedByName = "mapApplicantDto")
  @Mapping(target = "advisorDto", source = "advisor", qualifiedByName = "mapAdvisorDto")
  public abstract ApplicationDto toDto(Application application);

  @Named("mapApplicantDto")
  protected ApplicantDto mapApplicantDto(Applicant applicant) {
    return applicantMapper.toDto(applicant);
  }

  @Named("mapAdvisorDto")
  protected AdvisorDto mapAdvisorDto(Advisor advisor) {
    return advisorMapper.toDto(advisor);
  }

}
