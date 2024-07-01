package com.jif.emp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jif.emp.dto.EmpAddRequest;
import com.jif.emp.dto.EmpSearchRequest;
import com.jif.emp.dto.EmpUpdateRequest;
import com.jif.emp.entity.EmpInfo;

/**
 * 社員情報 Mapper
 */
@Mapper
public interface EmpInfoMapper {

   /**
    * 社員情報全件検索
    * 
    * @return 検索結果
    */
   List<EmpInfo> findAll();

   /**
    * 社員情報検索
    * 
    * @param emp 検索用リクエストデータ
    * @return 検索結果
    */
   List<EmpInfo> search(EmpSearchRequest empSearchRequest);

   /**
    * 社員情報登録
    * 
    * @param empAddRequest 登録用リクエストデータ
    */
   void save(EmpAddRequest empAddRequest);

   /**
    * 社員情報主キー検索
    * 
    * @param employeeID 主キー
    * @return 検索結果
    */
   EmpInfo findByKey(String employeeID);

   /**
    * 社員情報更新
    * 
    * @param empUpdateRequest 更新用リクエストデータ
    */
   void update(EmpUpdateRequest empUpdateRequest);
   
   /**
    * 社員情報の論理削除
    * @param employeeID 社員ID
    */
    void delete(String employeeID);
}