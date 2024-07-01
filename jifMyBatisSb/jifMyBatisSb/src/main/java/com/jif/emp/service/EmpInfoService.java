package com.jif.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jif.emp.dao.EmpInfoMapper;
import com.jif.emp.dto.EmpAddRequest;
import com.jif.emp.dto.EmpSearchRequest;
import com.jif.emp.dto.EmpUpdateRequest;
import com.jif.emp.entity.EmpInfo;

/**
 * 社員情報 Service
 */
@Service
public class EmpInfoService {

   /**
    * 社員情報 Mapper
    */
   @Autowired
   private EmpInfoMapper empInfoMapper;

   /**
    * 社員情報全件検索
    * 
    * @return 検索結果
    */
   public List<EmpInfo> findAll() {
      return empInfoMapper.findAll();
   }

   /**
    * 社員情報検索
    * 
    * @param empSearchRequest リクエストデータ
    * @return 検索結果
    */
   public List<EmpInfo> search(EmpSearchRequest empSearchRequest) {
      return empInfoMapper.search(empSearchRequest);
   }

   /**
    * 社員情報登録
    * 
    * @param empAddRequest リクエストデータ
    */
   public void save(EmpAddRequest empAddRequest) {
      empInfoMapper.save(empAddRequest);
   }

   /**
    * 社員情報主キー検索
    * 
    * @param employeeID 社員ID
    * @return 検索結果
    */
   public EmpInfo findByKey(String employeeID) {
      return empInfoMapper.findByKey(employeeID);
   }

    /**
     * 社員情報更新
     * @param empUpdateRequest リクエストデータ
     */
   public void update(EmpUpdateRequest empUpdateRequest) {
      empInfoMapper.update(empUpdateRequest);
   }
   
   /**
    * 社員情報論理削除
    * @param employeeID
    */
   public void delete(String employeeID) {
      empInfoMapper.delete(employeeID);
   }

}