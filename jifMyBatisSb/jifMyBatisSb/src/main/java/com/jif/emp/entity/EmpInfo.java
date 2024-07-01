package com.jif.emp.entity;

import lombok.Data;

/**
 * 社員情報 Entity
 */
@Data
public class EmpInfo {
   
      
   /**
     * 社員ID
     */
   private String employeeID;
   
   /** 
   名前（漢字）   
   */
   private String nameKanji1;
   
   /**
   名前（漢字）   
   */
   private String nameKanji2;
   
   /**
   名前（フリかな）   
   */
   private String nameKana1;
   
   /**
   名前（フリかな）  
   */ 
   private String nameKana2;
   
   /**
   名前（英語）   
   */
   private String nameEng1;
   
   /**
   名前（英語）
   */   
   private String nameEng2;
   
   /**
   生年月日   
   */
   private String birthday;
   
   /**
   性別   
   */
   private String sex;
   
   /**
   社員区分   
   */
   private String employeeFlag;
   
   /**
   入社日   
   */
   private String enterDay;
   
   /**
   退社日 
   */  
   private String leaveDay;
   
   /**
   郵便番号1   
   */
   private String postNo1;
   
   /**
   郵便番号2   
   */
   private String postNo2;
   
   /**
   住所１
   */   
   private String address1;
   
   /**
   住所２   
   */
   private String address2;
   
   /**
   連絡先１   
   */
   private String telNo1;
   
   /**
   連絡先２ 
   */  
   private String telNo2;
   
   /**
   メールアドレス１   
   */
   private String mail1;
   
   /**
   メールアドレス２   
   */
   private String mail2;
   
   /**
   権限区分   
   */
   private String authFlag;
   
   /**
   有効区分 
   */  
   private int effectFlag;
   
   /**
   登録者   
   */
   private String register;
   
   /**
   登録日時   
   */
   private String registDateTime;
   
   /**
   更新者   
   */
   private String modifyer;
   
   /**
   更新日時   
   */
   private String modifyDateTime;


}