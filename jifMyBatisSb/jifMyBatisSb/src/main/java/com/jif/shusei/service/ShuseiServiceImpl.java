//improt追加

@Service
public class ShuseiServiceImpl implements ShuseiService {

    @Autowired
    private ShuseiRepository shuseiRepository;

    @Override
    @Transactional
    public void saveShuseiDetails(ShuseiForm shuseiForm) {
        ShuseiEntity shuseiEntity = new ShuseiEntity();
        shuseiEntity.setFixedWorkDays(shuseiForm.getFixedWorkDays());
        shuseiEntity.setAbsentDays(shuseiForm.getAbsentDays());
        shuseiEntity.setHolidayWorkDays(shuseiForm.getHolidayWorkDays());
        shuseiEntity.setLawHolidayWorkDays(shuseiForm.getLawHolidayWorkDays());
        shuseiEntity.setSpecialLeaveDays(shuseiForm.getSpecialLeaveDays());
        shuseiEntity.setFixedWorkHours(shuseiForm.getFixedWorkHours());
        shuseiEntity.setNonTaxableCommutingAllowance(shuseiForm.getNonTaxableCommutingAllowance());
        shuseiEntity.setHousingAllowance(shuseiForm.getHousingAllowance());
        shuseiEntity.setNormalOvertimeAllowance(shuseiForm.getNormalOvertimeAllowance());
        shuseiEntity.setHolidayWorkAllowance(shuseiForm.getHolidayWorkAllowance());
        shuseiEntity.setLawHolidayWorkAllowance(shuseiForm.getLawHolidayWorkAllowance());
        shuseiEntity.setAbsentDeduction(shuseiForm.getAbsentDeduction());
        shuseiEntity.setLateEarlyLeaveDeduction(shuseiForm.getLateEarlyLeaveDeduction());
        shuseiEntity.setDependents(shuseiForm.getDependents());
        shuseiEntity.setBasicSalary(shuseiForm.getBasicSalary());
        shuseiEntity.setHealthInsurance(shuseiForm.getHealthInsurance());
        shuseiEntity.setCareInsurance(shuseiForm.getCareInsurance());
        shuseiEntity.setPensionInsurance(shuseiForm.getPensionInsurance());
        shuseiEntity.setEmploymentInsurance(shuseiForm.getEmploymentInsurance());
        shuseiEntity.setIncomeTax(shuseiForm.getIncomeTax());
        shuseiEntity.setResidentTax(shuseiForm.getResidentTax());
        shuseiEntity.setOther1(shuseiForm.getOther1());
        shuseiEntity.setOther1Value(shuseiForm.getOther1Value());
        shuseiEntity.setOther2(shuseiForm.getOther2());
        shuseiEntity.setOther2Value(shuseiForm.getOther2Value());
        shuseiEntity.setOther3(shuseiForm.getOther3());
        shuseiEntity.setOther3Value(shuseiForm.getOther3Value());
        shuseiEntity.setNetPay(shuseiForm.getNetPay());
        shuseiEntity.setBankTransferPay(shuseiForm.getBankTransferPay());
        shuseiEntity.setCashPay(shuseiForm.getCashPay());
        shuseiEntity.setInKindPay(shuseiForm.getInKindPay());

        // 저장
        shuseiRepository.save(shuseiEntity);
    }
}