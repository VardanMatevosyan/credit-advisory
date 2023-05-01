package com.example.credit_advisory.entity;

import static com.example.credit_advisory.entity.Application.Status.ASSIGNED;

import com.example.credit_advisory.entity.Application.Status;
import com.example.credit_advisory.entity.common.RoleAmount;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "advisors", schema = "credit_advisory")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Advisor extends User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  Integer id;

  @Column(name = "first_name", nullable = false)
  String firstName;

  @Column(name = "last_name", nullable = false)
  String lastName;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "role", nullable = false)
  Role role;

  @Setter(AccessLevel.PRIVATE)
  @OneToMany(mappedBy = "advisor")
  List<Application> applications = new ArrayList<>();

  public void assignApplication(Application application) {
    verifyNoAssignedApplication();
    application.setAdvisor(this);
    application.setStatus(ASSIGNED);
    application.setAssignAt(LocalDateTime.now());
    this.applications.add(application);
  }

  private void verifyNoAssignedApplication() {
    this.applications.stream()
        .filter(app -> app.status == ASSIGNED)
        .findAny()
        .ifPresent(app -> {
          throw new IllegalStateException("Advisor has already assigned application");
        });
  }

  public void cansel(Application application) {
    application.setAdvisor(null);
    applications.remove(application);
  }

  public BigDecimal getMinAmount() {
    return RoleAmount.getAmountByRoleName(this.role.name()).getMin();
  }

  public BigDecimal getMaxAmount() {
    return RoleAmount.getAmountByRoleName(this.role.name()).getMax();
  }

  public enum Role {
    ASSOCIATE, PARTNER, SENIOR;

  }

}
