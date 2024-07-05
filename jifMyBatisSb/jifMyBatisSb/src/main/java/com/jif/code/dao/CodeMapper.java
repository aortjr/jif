package com.jif.shusei.dao;

import com.jif.shusei.entity.ShuseiEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShuseiDao {
	void update(ShuseiEntity entity);

	void saveCombinedPayroll(ShuseiEntity entity);
}
