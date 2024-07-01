package com.jif.emp.dto;

import lombok.Data;

/**
 * 社員情報 検索用リクエストデータ
 */
@Data
public class EmpSearchRequest {

   /**
    * 社員ID
    */
   private String employeeID;

   /**
    * 名前（姓）
    */
   private String nameKanji1;

   /**
    * 名前（名）
    */
   private String nameKanji2;
   
   
   
   
}