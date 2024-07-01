package com.jif.code.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * コードマスタ登録用 データクラス
 */
@Data
public class CodeAddRequest {
	
	/**
	 * コード分類名
	 */
	@NotEmpty(message = "コード分類名を入力してください")
	@Size(max = 40, message = "コード分類名は40桁以内で入力してください")
	private String codeKindName;

	/**
	 * コード分類
	 */
	@NotEmpty(message = "コード分類を入力してください")
	@Size(max = 3, message = "コード分類は3桁以内で入力してください")
	private String codeKind;
	
	/**
	 * コード
	 */
	@NotEmpty(message = "コードを入力してください")
	@Size(max = 30, message = "コードは30桁以内で入力してください")
	private String code;

	/**
	 * コード名称
	 */
	@NotEmpty(message = "コード名称を入力してください")
	@Size(max = 40, message = "コード名称は40桁以内で入力してください")
	private String codeName;
	
	/**
	 * 表示順
	 */
	private int displayRank;

	
}
