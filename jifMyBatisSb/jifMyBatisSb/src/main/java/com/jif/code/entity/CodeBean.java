package com.jif.code.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeBean {

	/**
	 * コード分類
	 */
	private String codeKind;

	/**
	 * コード
	 */
	@NotEmpty(message = "コードを入力してください")
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

	/**
	 * 有効区分
	 */
	@NotEmpty(message = "有効区分を入力してください")
	private int effectFlag;

	/**
	 * 登録者
	 */
	private String register;

	/**
	 * 登録日時
	 */
	private String registDateTime;

	/**
	 * 更新者
	 */
	private String modifyer;

	/**
	 * 更新日時
	 */
	private String modifyDateTime;

}