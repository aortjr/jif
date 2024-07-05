package com.jif.shusei.service;

import com.jif.shusei.entity.ShuseiEntity;
import com.jif.shusei.form.ShuseiForm;
import com.jif.shusei.dao.ShuseiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShuseiServiceImpl {

    @Autowired
    private ShuseiDao shuseiDao;

    @Transactional
    public void updateForm(ShuseiForm form) {
        ShuseiEntity entity = new ShuseiEntity();
        // 폼 데이터를 엔티티로 매핑
        entity.setFixedWorkDays(form.getFixedWorkDays());
        entity.setAbsentDays(form.getAbsentDays());
        entity.setHolidayWorkDays(form.getHolidayWorkDays());
        entity.setLawHolidayWorkDays(form.getLawHolidayWorkDays());
        entity.setSpecialLeaveDays(form.getSpecialLeaveDays());
        entity.setFixedWorkHours(form.getFixedWorkHours());
        entity.setNonTaxableCommutingAllowance(form.getNonTaxableCommutingAllowance());
        entity.setHousingAllowance(form.getHousingAllowance());
        entity.setNormalOvertimeAllowance(form.getNormalOvertimeAllowance());
        entity.setHolidayWorkAllowance(form.getHolidayWorkAllowance());
        entity.setLawHolidayWorkAllowance(form.getLawHolidayWorkAllowance());
        entity.setAbsentDeduction(form.getAbsentDeduction());
        entity.setLateEarlyLeaveDeduction(form.getLateEarlyLeaveDeduction());
        entity.setDependents(form.getDependents());
        entity.setBasicSalary(form.getBasicSalary());
        entity.setHealthInsurance(form.getHealthInsurance());
        entity.setCareInsurance(form.getCareInsurance());
        entity.setPensionInsurance(form.getPensionInsurance());
        entity.setEmploymentInsurance(form.getEmploymentInsurance());
        entity.setIncomeTax(form.getIncomeTax());
        entity.setResidentTax(form.getResidentTax());
        entity.setOther1(form.getOther1());
        entity.setOther1Value(form.getOther1Value());
        entity.setOther2(form.getOther2());
        entity.setOther2Value(form.getOther2Value());
        entity.setOther3(form.getOther3());
        entity.setOther3Value(form.getOther3Value());
        entity.setNetPay(form.getNetPay());
        entity.setBankTransferPay(form.getBankTransferPay());
        entity.setCashPay(form.getCashPay());
        entity.setInKindPay(form.getInKindPay());

        // 엔티티를 업데이트
        shuseiDao.update(entity);
    }
}
