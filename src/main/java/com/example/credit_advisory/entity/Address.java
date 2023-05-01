package com.example.credit_advisory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Address {

  @Column(name = "city", nullable = false)
  String city;

  @Column(name = "street", nullable = false)
  String street;

  @Column(name = "number", nullable = false)
  String number;

  @Column(name = "zip", nullable = false)
  String zip;

  @Column(name = "apt", nullable = false)
  String apt;

}
