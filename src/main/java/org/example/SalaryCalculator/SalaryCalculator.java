package org.example.SalaryCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class SalaryCalculator {
    public static void main(String[] args) {
        Map<String, BigDecimal> taxes = new HashMap<>();

        taxes.put("DISABILITY_PENSION_CONTRIBUTION", new BigDecimal(System.getenv("DISABILITY_PENSION_CONTRIBUTION")));
        taxes.put("SICKNESS_INSURANCE_CONTRIBUTION", new BigDecimal(System.getenv("SICKNESS_INSURANCE_CONTRIBUTION")));
        taxes.put("RETIREMENT_PENSION_CONTRIBUTION", new BigDecimal(System.getenv("RETIREMENT_PENSION_CONTRIBUTION")));
        taxes.put("HEALTH_INSURANCE_CONTRIBUTION", new BigDecimal(System.getenv("HEALTH_INSURANCE_CONTRIBUTION")));
        taxes.put("HEALTH_INSURANCE_DEDUCTION", new BigDecimal(System.getenv("HEALTH_INSURANCE_DEDUCTION")));
        taxes.put("TAX_THRESHOLD", new BigDecimal(System.getenv("TAX_THRESHOLD")));
        taxes.put("TAX_FREE_ALLOWANCE", new BigDecimal(System.getenv("TAX_FREE_ALLOWANCE")));
        taxes.put("COST_OF_EARNING_INCOME", new BigDecimal(System.getenv("COST_OF_EARNING_INCOME")));

        BigDecimal netSalary = calcSalary(BigDecimal.valueOf(2250), taxes);
        System.out.println(netSalary);
    }

    public static BigDecimal calcSalary(BigDecimal salary, Map<String, BigDecimal> taxes) {

        BigDecimal socialInsurance = getSocialInsuranceValue(salary, taxes);

        BigDecimal healthInsurance = getHealthInsuranceValue(salary, taxes);

        BigDecimal advancePaymentOfIncomeTax = getAdvancePaymentOfIncomeTaxValue(salary, taxes);

        BigDecimal incomeTax = getIncomeTaxValue(advancePaymentOfIncomeTax, taxes);

        return salary.subtract(socialInsurance).subtract(healthInsurance).subtract(incomeTax);
    }

    private static BigDecimal getSocialInsuranceValue(BigDecimal salary, Map<String, BigDecimal> taxes) {
        return salary.multiply(
                taxes.get("DISABILITY_PENSION_CONTRIBUTION")
                        .add(taxes.get("SICKNESS_INSURANCE_CONTRIBUTION"))
                        .add(taxes.get("RETIREMENT_PENSION_CONTRIBUTION"))
        ).setScale(2, RoundingMode.HALF_UP);
    }

    private static BigDecimal getHealthInsuranceValue(BigDecimal salary, Map<String, BigDecimal> taxes) {
        return salary
                .subtract(getSocialInsuranceValue(salary, taxes))
                .multiply(taxes.get("HEALTH_INSURANCE_CONTRIBUTION"))
                .setScale(2, RoundingMode.HALF_UP);
    }

    private static BigDecimal getAdvancePaymentOfIncomeTaxValue(BigDecimal salary, Map<String, BigDecimal> taxes) {
        return salary
                .subtract(getSocialInsuranceValue(salary, taxes))
                .subtract(taxes.get("TAX_FREE_ALLOWANCE"))
                .setScale(0, RoundingMode.HALF_UP);
    }

    private static BigDecimal getIncomeTaxValue(BigDecimal salary, Map<String, BigDecimal> taxes) {
        return getAdvancePaymentOfIncomeTaxValue(salary, taxes)
                .multiply(taxes.get("TAX_THRESHOLD"))
                .subtract(taxes.get("COST_OF_EARNING_INCOME"))
                .subtract(
                        salary.subtract(getSocialInsuranceValue(salary, taxes))
                                .multiply(taxes.get("HEALTH_INSURANCE_DEDUCTION"))
                )
                .setScale(0, RoundingMode.HALF_UP);
    }
}