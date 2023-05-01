package com.example.credit_advisory.repository;

import com.example.credit_advisory.entity.Application;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

  @Query("select app from Application app "
      + " where app.status = 'NEW' and app.amount >= :min and app.amount <= :max ")
  Optional<Application> findFirstNewByAmountInRange(BigDecimal min, BigDecimal max);

}
