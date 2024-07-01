package com.jif.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jif.code.dao.CodeMapper;
import com.jif.code.dto.CodeAddRequest;
import com.jif.code.entity.CodeBean;

@Service
public class CodeService {

	@Autowired
	private CodeMapper codeMapper;

	public List<CodeBean> findAll() {
		return codeMapper.findAll();
	}
	
	public List<CodeBean> findByCodeKind(String codeKind) {
		return codeMapper.findByCodeKind(codeKind);
	}

	public CodeBean findOne(String codeKind, String code) {
		return codeMapper.findOne(codeKind, code);
	}

	@Transactional
	public void insert(CodeAddRequest codeAddRequest) {
		codeMapper.insert(codeAddRequest);
	}

	@Transactional
	public void update(CodeBean codeBean) {
		codeMapper.update(codeBean);
	}

	@Transactional
	public void delete(String codeKind, String code) {
		codeMapper.delete(codeKind, code);
	}
    
	@Transactional
	public void insert2(CodeAddRequest codeAddRequest) {
		
		String maxCode = codeMapper.findCodeMax();
		maxCode = String.valueOf(Integer.parseInt(maxCode) + 1);
		
		// コード分類データ（codeKind = 0）
		CodeAddRequest codeAddRequestZero = new CodeAddRequest();
		codeAddRequestZero.setCodeKind("0");
		codeAddRequestZero.setCode(maxCode);
		codeAddRequestZero.setCodeName(codeAddRequest.getCodeKindName());
		codeMapper.insert(codeAddRequestZero);
		
	
		// コードデータ（codeKind != 0）
		CodeAddRequest codeAddRequestNotZero = new CodeAddRequest();
		codeAddRequestNotZero.setCodeKind(maxCode);
		codeAddRequestNotZero.setCode(codeAddRequest.getCode());
		codeAddRequestNotZero.setCodeName(codeAddRequest.getCodeName());
		codeAddRequestNotZero.setDisplayRank(codeAddRequest.getDisplayRank());
		codeMapper.insert(codeAddRequestNotZero);
		
	}



	

	

}
