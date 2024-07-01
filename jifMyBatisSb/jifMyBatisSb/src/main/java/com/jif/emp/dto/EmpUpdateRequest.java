package com.jif.emp.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 社員情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EmpUpdateRequest extends EmpAddRequest {

   /**
    * 有効区分
    */
   private int effectFlag;
   
   /**
    * 退社日
    */
   private String leaveDay;
}
