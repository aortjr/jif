package com.jif.shusei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jif.shusei.form.ShuseiForm;
import com.jif.shusei.service.ShuseiServiceImpl;

@Controller
public class ShuseiController {

    @Autowired
    private ShuseiServiceImpl shuseiService;

    // 編集画面を表示するGETリクエスト
    @GetMapping("/edit")
    public String showEditForm(Model model) {
        // 新しい修正フォームを作成して、モデルに追加
        ShuseiForm form = new ShuseiForm();
        model.addAttribute("form", form);
        return "shusei/edit"; // 修正画面のテンプレートを返す
    }

    // 修正内容を保存するPOSTリクエスト
    @PostMapping("/save")
    public String saveShusei(@ModelAttribute("form") ShuseiForm form) {
        // サービスを介して修正内容を保存
        shuseiService.updateForm(form);
        return "redirect:/ichiran"; // 一覧画面にリダイレクト
    }

    @PostMapping("/total")
    public String saveForm(@ModelAttribute PayrollForm form, Model model) {
        // 서버 측에서 합계 계산
        int totalWorkDays = form.getFixedWorkDays() + form.getAbsentDays() + form.getHolidayWorkDays();
        int totalPayment = form.getBasicSalary() + form.getNonTaxableCommutingAllowance() + form.getHousingAllowance();
        int totalDeduction = form.getHealthInsurance() + form.getCareInsurance() + form.getPensionInsurance();

        // 합계 값들을 모델에 추가
        model.addAttribute("totalWorkDays", totalWorkDays);
        model.addAttribute("totalPayment", totalPayment);
        model.addAttribute("totalDeduction", totalDeduction);
        model.addAttribute("form", form);

        return "payroll";
    }
}