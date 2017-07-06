package cn.wasis.mapper;

import cn.wasis.entity.Dept;

public interface DeptMapper {

	Dept findByIdLoadUser(Integer id);
	
}
