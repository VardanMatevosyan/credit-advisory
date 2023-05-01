package com.example.credit_advisory.mapper;

import com.example.credit_advisory.dto.ApplicantDto;
import com.example.credit_advisory.entity.Applicant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ApplicantMapper {

  ApplicantDto toDto(Applicant applicant);
}
