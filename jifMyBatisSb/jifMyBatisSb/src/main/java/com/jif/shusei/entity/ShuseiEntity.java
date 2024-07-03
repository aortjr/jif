package com.jif.shusei.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShuseiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fixedWorkDays;
    private String absentDays;
    private String holidayWorkDays;
    private String lawHolidayWorkDays;
    private String specialLeaveDays;
    private String fixedWorkHours;
    private String nonTaxableCommutingAllowance;
    private String housingAllowance;
    private String normalOvertimeAllowance;
    private String holidayWorkAllowance;
    private String lawHolidayWorkAllowance;
    private String absentDeduction;
    private String lateEarlyLeaveDeduction;
    private String dependents;
    private String basicSalary;
    private String healthInsurance;
    private String careInsurance;
    private String pensionInsurance;
    private String employmentInsurance;
    private String incomeTax;
    private String residentTax;
    private String other1;
    private String other1Value;
    private String other2;
    private String other2Value;
    private String other3;
    private String other3Value;
    private String netPay;
    private String bankTransferPay;
    private String cashPay;
    private String inKindPay;

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFixedWorkDays() {
        return fixedWorkDays;
    }

    public void setFixedWorkDays(String fixedWorkDays) {
        this.fixedWorkDays = fixedWorkDays;
    }

    public String getAbsentDays() {
        return absentDays;
    }

    public void setAbsentDays(String absentDays) {
        this.absentDays = absentDays;
    }

    public String getHolidayWorkDays() {
        return holidayWorkDays;
    }

    public void setHolidayWorkDays(String holidayWorkDays) {
        this.holidayWorkDays = holidayWorkDays;
    }

    public String getLawHolidayWorkDays() {
        return lawHolidayWorkDays;
    }

    public void setLawHolidayWorkDays(String lawHolidayWorkDays) {
        this.lawHolidayWorkDays = lawHolidayWorkDays;
    }

    public String getSpecialLeaveDays() {
        return specialLeaveDays;
    }

    public void setSpecialLeaveDays(String specialLeaveDays) {
        this.specialLeaveDays = specialLeaveDays;
    }

    public String getFixedWorkHours() {
        return fixedWorkHours;
    }

    public void setFixedWorkHours(String fixedWorkHours) {
        this.fixedWorkHours = fixedWorkHours;
    }

    public String getNonTaxableCommutingAllowance() {
        return nonTaxableCommutingAllowance;
    }

    public void setNonTaxableCommutingAllowance(String nonTaxableCommutingAllowance) {
        this.nonTaxableCommutingAllowance = nonTaxableCommutingAllowance;
    }

    public String getHousingAllowance() {
        return housingAllowance;
    }

    public void setHousingAllowance(String housingAllowance) {
        this.housingAllowance = housingAllowance;
    }

    public String getNormalOvertimeAllowance() {
        return normalOvertimeAllowance;
    }

    public void setNormalOvertimeAllowance(String normalOvertimeAllowance) {
        this.normalOvertimeAllowance = normalOvertimeAllowance;
    }

    public String getHolidayWorkAllowance() {
        return holidayWorkAllowance;
    }

    public void setHolidayWorkAllowance(String holidayWorkAllowance) {
        this.holidayWorkAllowance = holidayWorkAllowance;
    }

    public String getLawHolidayWorkAllowance() {
        return lawHolidayWorkAllowance;
    }

    public void setLawHolidayWorkAllowance(String lawHolidayWorkAllowance) {
        this.lawHolidayWorkAllowance = lawHolidayWorkAllowance;
    }

    public String getAbsentDeduction() {
        return absentDeduction;
    }

    public void setAbsentDeduction(String absentDeduction) {
        this.absentDeduction = absentDeduction;
    }

    public String getLateEarlyLeaveDeduction() {
        return lateEarlyLeaveDeduction;
    }

    public void setLateEarlyLeaveDeduction(String lateEarlyLeaveDeduction) {
        this.lateEarlyLeaveDeduction = lateEarlyLeaveDeduction;
    }

    public String getDependents() {
        return dependents;
    }

    public void setDependents(String dependents) {
        this.dependents = dependents;
    }

    public String getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(String healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public String getCareInsurance() {
        return careInsurance;
    }

    public void setCareInsurance(String careInsurance) {
        this.careInsurance = careInsurance;
    }

    public String getPensionInsurance() {
        return pensionInsurance;
    }

    public void setPensionInsurance(String pensionInsurance) {
        this.pensionInsurance = pensionInsurance;
    }

    public String getEmploymentInsurance() {
        return employmentInsurance;
    }

    public void setEmploymentInsurance(String employmentInsurance) {
        this.employmentInsurance = employmentInsurance;
    }

    public String getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(String incomeTax) {
        this.incomeTax = incomeTax;
    }

    public String getResidentTax() {
        return residentTax;
    }

    public void setResidentTax(String residentTax) {
        this.residentTax = residentTax;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther1Value() {
        return other1Value;
    }

    public void setOther1Value(String other1Value) {
        this.other1Value = other1Value;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public String getOther2Value() {
        return other2Value;
    }

    public void setOther2Value(String other2Value) {
        this.other2Value = other2Value;
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3;
    }

    public String getOther3Value() {
        return other3Value;
    }

    public void setOther3Value(String other3Value) {
        this.other3Value = other3Value;
    }

    public String getNetPay() {
        return netPay;
    }

    public void setNetPay(String netPay) {
        this.netPay = netPay;
    }

    public String getBankTransferPay() {
        return bankTransferPay;
    }

    public void setBankTransferPay(String bankTransferPay) {
        this.bankTransferPay = bankTransferPay;
    }

    public String getCashPay() {
        return cashPay;
    }

    public void setCashPay(String cashPay) {
        this.cashPay = cashPay;
    }

    public String getInKindPay() {
        return inKindPay;
    }

    public void setInKindPay(String inKindPay) {
        this.inKindPay = inKindPay;
    }
}