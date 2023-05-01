package com.example.credit_advisory.repository;

import com.example.credit_advisory.entity.Advisor;
import com.example.credit_advisory.entity.Application;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdvisorRepository extends JpaRepository<Advisor, Integer> {

}
