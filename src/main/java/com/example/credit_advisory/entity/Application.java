package com.example.credit_advisory.entity;

import static java.util.Objects.nonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "applications", schema = "credit_advisory")
public class Application {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "applicant_id", nullable = false)
  Applicant applicant;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "advisor_id")
  Advisor advisor;

  @Column(name = "amount")
  BigDecimal amount;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "status", nullable = false)
  Status status;

  @Column(name = "created_at", nullable = false)
  LocalDateTime createdAt = LocalDateTime.now();

  @Column(name = "assign_at", nullable = false)
  LocalDateTime assignAt = LocalDateTime.now();

  @Column(name = "resolved_at", nullable = false)
  LocalDateTime resolvedAt = LocalDateTime.now();

  public enum Status {
    NEW, ASSIGNED, ON_HOLD, APPROVED, CANCELED, DECLINED;
  }

  public void assignTo(Advisor advisor) {
    this.advisor = advisor;
    this.status = Status.ASSIGNED;
    this.assignAt = LocalDateTime.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Application that = (Application) o;
    return nonNull(id) && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}


