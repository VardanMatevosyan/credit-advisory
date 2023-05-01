package com.example.credit_advisory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "number")
@Embeddable
public class PhoneNumber {

  @Column(name = "number", nullable = false)
  String number;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "type", nullable = false)
  Type phoneType;

  enum Type {
    HOME, WORK, MOBILE
  }
}
