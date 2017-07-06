package cn.wasis.mapper;

import java.util.List;

import cn.wasis.entity.User;

public interface UserMapper {

	User findById(Integer id);
	List<User> findAll();
	void save(User user);
	void update(User user);
	void delById(Integer id);
	
	List<User> findAllLoadDept();
	
}
