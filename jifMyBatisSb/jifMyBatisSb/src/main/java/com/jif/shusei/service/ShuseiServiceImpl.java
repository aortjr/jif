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
    //修正関連
    public void updateForm(ShuseiForm form) {
        ShuseiEntity entity = new ShuseiEntity();
        // フォームデータをエンティティにマッピング
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

        // エンティティをアップデート
        shuseiDao.update(entity);
    }

    //修正予定
    public String getData(int value) {
        if (value >= 1 && value <= 10) {
            // 値が1～10の場合、1番目の項目の特定データを取得
            return fetchFromTable1();
        } else if (value >= 11 && value <= 20) {
            // 値が11～20の場合、2番目の項目の特定データを取得
            return fetchFromTable2();
        } else {
            // その他の範囲に対する処理や例外処理が必要
            throw new IllegalArgumentException("Value must be between 1 and 20");
        }
    }

    //修正予定
    private String fetchFromTable1() {
        // Table 1からデータを取得し返すロジック
        return "Data from Table 1";
    }

    private String fetchFromTable2() {
        // Table 2からデータを取得し返すロジック
        return "Data from Table 2";
    }
}

