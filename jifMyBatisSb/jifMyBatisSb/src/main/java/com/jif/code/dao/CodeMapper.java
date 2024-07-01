package com.jif.code.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jif.code.dto.CodeAddRequest;
import com.jif.code.entity.CodeBean;


@Mapper
public interface CodeMapper {
	
	List<CodeBean> findAll();
	
	List<CodeBean> findByCodeKind(String codeKind);

	CodeBean findOne(String codeKind, String code);

	void insert(CodeAddRequest codeAddRequest);
	
	void update(CodeBean codeBean);
	
	void delete(String codeKind, String code);

	String findCodeMax();

}