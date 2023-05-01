package com.example.credit_advisory.mapper;

import com.example.credit_advisory.dto.AdvisorDto;
import com.example.credit_advisory.entity.Advisor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AdvisorMapper {

  AdvisorDto toDto(Advisor advisor);

}
