package com.example.credit_advisory.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = {"ssn"}, callSuper = true)
@Entity
@Table(name = "applicants", schema = "credit_advisory")
public class Applicant extends User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  Integer id;

  @NaturalId
  @Column(name = "ssn", nullable = false, unique = true)
  String ssn;

  @Column(name = "first_name", nullable = false)
  String firstName;

  @Column(name = "last_name", nullable = false)
  String lastName;

  @Embedded
  Address address;

  @Setter(AccessLevel.PRIVATE)
  @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, orphanRemoval = true)
  List<Application> applications = new ArrayList<>();

  @ElementCollection
  @CollectionTable(name = "applicant_phones",
      schema = "credit_advisory",
      joinColumns = @JoinColumn(name = "applicant_id"))
  List<PhoneNumber> phoneNumbers = new ArrayList<>();

  public void addApplication(Application application) {
    applications.add(application);
    application.setApplicant(this);
  }

  public void canselApplication(Application application) {
    applications.remove(application);
    application.setApplicant(null);
  }


}
