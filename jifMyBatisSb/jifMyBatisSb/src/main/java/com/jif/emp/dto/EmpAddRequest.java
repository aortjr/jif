package com.jif.emp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 社員情報登録 リクエストデータ
 */

@Data
public class EmpAddRequest {

   /**
    * 社員ID
    */
   @NotEmpty(message = "社員IDを入力してください")
   @Size(min = 10, max = 10, message = "社員IDは10桁で入力してください")
   private String employeeID;

   /**
    * 名前（姓）
    */
   @Size(max = 10, message = "名前（姓）は10桁以内で入力してください")
   private String nameKanji1;

   /**
    * 名前（名）
    */
   @Size(max = 10, message = "名前（名）は10桁以内で入力してください")
   private String nameKanji2;

   /**
    * 名前（姓）（フリかな）
    */
   @NotEmpty(message = "名前（姓）（フリかな）を入力してください")
   @Size(max = 20, message = "名前（姓)(フリかな）は20桁以内で入力してください")
   private String nameKana1;

   /**
    * 名前（名）（フリかな）
    */
   @NotEmpty(message = "名前（名）（フリかな）を入力してください")
   @Size(max = 20, message = "名前（名)(フリかな）は20桁以内で入力してください")
   private String nameKana2;

   /**
    * 名前（姓）（英語）
    */
   @NotEmpty(message = "名前（姓）（英語） を入力してください")
   @Size(max = 20, message = "名前（姓)(英語）は20桁以内で入力してください")
   private String nameEng1;

   /**
    * 名前（名）（英語）
    */
   @NotEmpty(message = "名前（名）（英語）を入力してください")
   @Size(max = 20, message = "名前（姓)(英語）は20桁以内で入力してください")
   private String nameEng2;

   /**
    * 生年月日
    */
   @NotEmpty(message = "生年月日を入力してください")
   private String birthday;

   /**
    * 性別
    */
   @NotEmpty(message = "性別を入力してください　 0：男性、1：女性")
   private String sex;

   /**
    * 社員区分
    */
   @NotEmpty(message = "社員区分を入力してください 　R：正社員、C：契約社員、P：アルバイト")
   private String employeeFlag;

   /**
    * 入社日
    */
   @NotEmpty(message = "入社日を入力してください")
   private String enterDay;

   /**
    * 郵便番号1
    */
   @Size(min = 3, max = 3, message = "郵便番号1は3桁で入力してください")
   private String postNo1;

   /**
    * 郵便番号2
    */
   @Size(min = 4, max = 4, message = "郵便番号2は4桁で入力してください")
   private String postNo2;

   /**
    * 住所１
    */
   @Size(max = 30, message = "住所１は30桁以内で入力してください")
   private String address1;

   /**
    * 住所２
    */
   @Size(max = 30, message = "住所2は30桁以内で入力してください")
   private String address2;

   /**
    * 連絡先１
    */
   @Size(max = 15, message = "連絡先１は15桁以内で入力してください")
   private String telNo1;

   /**
    * 連絡先２
    */
   @Size(max = 15, message = "連絡先2は15桁以内で入力してください")
   private String telNo2;

   /**
    * メールアドレス１
    */
   @Size(max = 30, message = "メールアドレス１は30桁以内で入力してください")
   private String mail1;

   /**
    * メールアドレス２
    */
   @Size(max = 30, message = "メールアドレス2は30桁以内で入力してください")
   private String mail2;

}