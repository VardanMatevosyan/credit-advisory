package com.example.credit_advisory.entity.common;

import static java.util.Objects.isNull;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum RoleAmount {

  ASSOCIATE(BigDecimal.ZERO, BigDecimal.valueOf(10000)),
  PARTNER(BigDecimal.valueOf(10000), BigDecimal.valueOf(15000)),
  SENIOR(BigDecimal.valueOf(15000), BigDecimal.valueOf(Integer.MAX_VALUE));

  BigDecimal min;
  BigDecimal max;

  static final Map<String, RoleAmount> ROLE_AMOUNT = collectRoleAmounts();

  public static RoleAmount getAmountByRoleName(String name) {
    RoleAmount roleAmount = ROLE_AMOUNT.get(name);
    if (isNull(roleAmount)) {
      throw new IllegalStateException("There is no role roleAmount configuration exists");
    }
    return roleAmount;
  }

  private static Map<String, RoleAmount> collectRoleAmounts() {
    return Arrays.stream(values()).collect(toMap(Enum::name, identity()));
  }
}
