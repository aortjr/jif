package com.jif.code.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation .Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jif.code.dto.CodeAddRequest;
import com.jif.code.entity.CodeBean;
import com.jif.code.service.CodeService;

@Controller
@RequestMapping("/codeList")
public class CodeMasterController {
	
//List	
	
	@Autowired
	private CodeService codeService;

	@GetMapping
	public String list(Model model) {
		model.addAttribute("codeBeans", codeService.findAll());
		model.addAttribute("codeKinds", codeService.findByCodeKind("0"));
		return "code/search";
	}

	@PostMapping("{selectedId}")
	public String updateListTable(@PathVariable String selectedId, Model model) {
//		System.out.println("【selectedId】：" + selectedId);
		
		List<CodeBean> list= null;
		if ("99".equals(selectedId)) {
			list = codeService.findAll();
		} else {
			list = codeService.findByCodeKind(selectedId);
		}
//		System.out.println("【list.size()】：" + list.size());
		
		
		
		model.addAttribute("codeBeans", list);
		return "code/search :: list-fragment";
	}
	
	
//Regist
	

	@GetMapping("{codeKind}/{codeKindName}")
	public String newCodeMaster(@PathVariable String codeKind, @PathVariable String codeKindName, Model model) {

		if ("88".equals(codeKind)) {
			codeKindName = "";
		}

		CodeAddRequest codeAddRequest = new CodeAddRequest();
		codeAddRequest.setCodeKind(codeKind);
		codeAddRequest.setCodeKindName(codeKindName);

		model.addAttribute("codeAddRequest", codeAddRequest);

		return "code/new";
	}

	@PostMapping
	public String insert(@Validated @ModelAttribute CodeAddRequest codeAddRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {

			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				if (!errorList.contains(error.getDefaultMessage())) {
					errorList.add(error.getDefaultMessage());
				}
			}

			model.addAttribute("validationError", errorList);

			return "code/codeNew";
		}
		
		if ("88".equals(codeAddRequest.getCodeKind())) {
			codeService.insert2(codeAddRequest);
			
		} else {	
			codeService.insert(codeAddRequest);
		}
		
		return "redirect:/codeList";
	}
	
//Edit	
	
	@PostMapping("{codeKind}/{code}/update")
	public String update(@PathVariable String codeKind, @PathVariable String code, @ModelAttribute CodeBean codeBean) {
		codeBean.setCodeKind(codeKind);
		codeBean.setCode(code);
		codeService.update(codeBean);
		return "redirect:/codeList";
	}

	@GetMapping("{codeKind}/{code}/edit")
	public String edit(@PathVariable String codeKind, @PathVariable String code, Model model) {
		model.addAttribute("codeBean", codeService.findOne(codeKind, code));
		return "code/edit";
	}
	
//Show

	@GetMapping("{codeKind}/{code}/show")
	public String show(@PathVariable String codeKind, @PathVariable String code, Model model) {
		model.addAttribute("codeBean", codeService.findOne(codeKind, code));
		return "code/show";
	}
	
//Delete
	
	@PostMapping("{codeKind}/{code}/delete")
	public String delete(@PathVariable String codeKind, @PathVariable String code) {
		codeService.delete(codeKind, code);
		return "redirect:/search";
	}

}
