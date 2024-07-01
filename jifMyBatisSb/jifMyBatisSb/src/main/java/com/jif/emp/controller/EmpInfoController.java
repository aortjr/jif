package com.jif.emp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jif.emp.dto.EmpAddRequest;
import com.jif.emp.dto.EmpSearchRequest;
import com.jif.emp.dto.EmpUpdateRequest;
import com.jif.emp.entity.EmpInfo;
import com.jif.emp.service.EmpInfoService;

/**
 * 社員情報 Controller
 */
@Controller
public class EmpInfoController {

   /**
    * 社員情報 Service
    */
   @Autowired
   private EmpInfoService empInfoService;

   /**
    * 社員情報一覧画面を表示
    * 
    * @param model Model
    * @return 社員情報一覧画面
    */
   @GetMapping(value = "/emp/list")
   public String displayList(Model model) {
      List<EmpInfo> emplist = empInfoService.findAll();
      model.addAttribute("emplist", emplist);
      model.addAttribute("empSearchRequest", new EmpSearchRequest());
      return "emp/search";
   }

   /**
    * 社員情報検索
    * 
    * @param empSearchRequest リクエストデータ
    * @param model            Model
    * @return 社員情報一覧画面
    */
   @RequestMapping(value = "/emp/search", method = RequestMethod.POST)
   public String search(@ModelAttribute EmpSearchRequest empSearchRequest, Model model) {
      List<EmpInfo> emplist = empInfoService.search(empSearchRequest);
      model.addAttribute("emplist", emplist);
      return "emp/search";
   }

   /**
    * 社員新規登録画面を表示
    * 
    * @param model Model
    * @return 社員新規登録画面
    */
   @GetMapping(value = "/emp/add")
   public String displayAdd(Model model) {
      model.addAttribute("empAddRequest", new EmpAddRequest());
      return "emp/add";
   }

   /**
    * 社員新規登録
    * 
    * @param userRequest リクエストデータ
    * @param model       Model
    * @return 社員情報一覧画面
    */
   @RequestMapping(value = "/emp/create", method = RequestMethod.POST)
   public String create(@Validated @ModelAttribute EmpAddRequest empRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {
         // 入力チェックエラーの場合
         List<String> errorList = new ArrayList<String>();
         for (ObjectError error : result.getAllErrors()) {
            errorList.add(error.getDefaultMessage());
         }
         model.addAttribute("validationError", errorList);
         return "emp/add";
      }
      // 社員情報の登録
      empInfoService.save(empRequest);
      return "redirect:/emp/list";
   }

   /**
    * 社員編集画面を表示
    * 
    * @param id    ユーザーID
    * @param model Model
    * @return 社員編集画面
    */
   @GetMapping("/emp/{employeeID}/edit")
   public String displayEdit(@PathVariable String employeeID, Model model) {
      EmpInfo empInfo = empInfoService.findByKey(employeeID);
      EmpUpdateRequest empUpdateRequest = new EmpUpdateRequest();
      empUpdateRequest.setEmployeeID(empInfo.getEmployeeID());
      empUpdateRequest.setNameKanji1(empInfo.getNameKanji1());
      empUpdateRequest.setNameKanji2(empInfo.getNameKanji2());
      empUpdateRequest.setNameKana1(empInfo.getNameKana1());
      empUpdateRequest.setNameKana2(empInfo.getNameKana2());
      empUpdateRequest.setNameEng1(empInfo.getNameEng1());
      empUpdateRequest.setNameEng2(empInfo.getNameEng2());
      empUpdateRequest.setBirthday(empInfo.getBirthday());
      empUpdateRequest.setSex(empInfo.getSex());
      empUpdateRequest.setEmployeeFlag(empInfo.getEmployeeFlag());
      empUpdateRequest.setEnterDay(empInfo.getEnterDay());
      empUpdateRequest.setLeaveDay(empInfo.getLeaveDay());
      empUpdateRequest.setPostNo1(empInfo.getPostNo1());
      empUpdateRequest.setPostNo2(empInfo.getPostNo2());
      empUpdateRequest.setAddress1(empInfo.getAddress1());
      empUpdateRequest.setAddress2(empInfo.getAddress2());
      empUpdateRequest.setTelNo1(empInfo.getTelNo1());
      empUpdateRequest.setTelNo2(empInfo.getTelNo2());
      empUpdateRequest.setMail1(empInfo.getMail1());
      empUpdateRequest.setMail2(empInfo.getMail2());
      empUpdateRequest.setEffectFlag(empInfo.getEffectFlag());

      model.addAttribute("empUpdateRequest", empUpdateRequest);
      return "emp/edit";
   }
   
   /**
     * 社員更新
     * @param userRequest リクエストデータ
     * @param model Model
     * @return 社員情報一覧画面
     */
    @RequestMapping(value = "/emp/update", method = RequestMethod.POST)
    public String update(@Validated @ModelAttribute EmpUpdateRequest empUpdateRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "emp/edit";
        }
        // 社員情報の更新
        empInfoService.update(empUpdateRequest);
        return "redirect:/emp/list";
    }
    
    /**
     * 社員情報削除（論理削除）
     * @param employeeID 社員ID
     * @param model Model
     * @return 社員情報一覧画面
     */
    @GetMapping("/emp/{employeeID}/delete")
    public String delete(@PathVariable String employeeID, Model model) {
        // 社員情報の削除
       empInfoService.delete(employeeID);
        return "redirect:/emp/list"; 
    }
}