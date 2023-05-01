package com.example.credit_advisory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(of = "cognitoUserName")
public abstract class User {

  @NaturalId
  @Column(name = "cognito_username", nullable = false, updatable = false, unique = true)
  String cognitoUserName;

  @Column(name = "cognito_group", nullable = false)
  String cognitoGroup;

  @Column(name = "email", nullable = false, unique = true)
  String email;
}
