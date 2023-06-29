package org.example.SalaryCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SalaryCalculatorTest {

    @Test
    public void testCalcSalary() {
        //given
        Map<String, BigDecimal> taxes = new HashMap<>();
        taxes.put("DISABILITY_PENSION_CONTRIBUTION", new BigDecimal("0.015"));
        taxes.put("SICKNESS_INSURANCE_CONTRIBUTION", new BigDecimal("0.0245"));
        taxes.put("RETIREMENT_PENSION_CONTRIBUTION", new BigDecimal("0.0976"));
        taxes.put("HEALTH_INSURANCE_CONTRIBUTION", new BigDecimal("0.09"));
        taxes.put("HEALTH_INSURANCE_DEDUCTION", new BigDecimal("0.0775"));
        taxes.put("TAX_THRESHOLD", new BigDecimal("0.18"));
        taxes.put("TAX_FREE_ALLOWANCE", new BigDecimal("111.25"));
        taxes.put("COST_OF_EARNING_INCOME", new BigDecimal("46.33"));

        BigDecimal salary = new BigDecimal("2250");
        BigDecimal expectedNetSalary = new BigDecimal("1633.78");

        //when
        BigDecimal netSalary = SalaryCalculator.calcSalary(salary, taxes);

        //then
        Assertions.assertEquals(expectedNetSalary, netSalary);
    }

}