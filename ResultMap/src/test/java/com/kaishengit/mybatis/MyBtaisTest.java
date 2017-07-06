package com.kaishengit.mybatis;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kaishengit.entity.User;
import com.kaishengit.util.MyBatisUtil;

public class MyBtaisTest {
	
	private Logger logger = LoggerFactory.getLogger(MyBtaisTest.class);
	
	@Test
	public void first() throws Exception {
		
		//1. ���������ļ�
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2. ����SqlSessionFactory
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3. ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4. �������ݿ�
		
		User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",1);
		System.out.println(user.getUserName());
		System.out.println(user.getAddress());
		
		
		//5. �ر�sqlSession
		sqlSession.close();
		
		
	}
	
	
	@Test
	public void findAll() throws Exception {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		//4. �������ݿ�
		
		List<User> userList = sqlSession.selectList("com.kaishengit.mapper.UserMapper.findAll");
		for(User user : userList) {
			logger.debug("{} -> {} -> {}",user.getId(),user.getUserName(),user.getAddress());
		}
		
		
		//5. �ر�sqlSession
		sqlSession.close();
		
		
	}
	
	
	@Test
	public void save() throws Exception {
		
		//1. ���������ļ�
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2. ����SqlSessionFactory
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3. ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//4. �������ݿ�
		
		User user = new User();
		user.setAddress("����");
		user.setUserName("��һΰ");
		user.setPassword("333444");
		
		sqlSession.insert("com.kaishengit.mapper.UserMapper.save",user);
		
		//5.�ύ����
		//sqlSession.commit();
		
		//6. �ر�sqlSession
		sqlSession.close();
		
		
	}
	
	@Test
	public void update() throws Exception {
		
		//1. ���������ļ�
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2. ����SqlSessionFactory
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3. ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4. �������ݿ�
		
		User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",2);
		user.setAddress("�Ϻ�");
		
		sqlSession.update("com.kaishengit.mapper.UserMapper.update",user);
		
		
		//5.�ύ����
		sqlSession.commit();
		
		//6. �ر�sqlSession
		sqlSession.close();
		
		
	}
	
	@Test
	public void delete() throws Exception {
		
		//1. ���������ļ�
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2. ����SqlSessionFactory
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3. ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4. �������ݿ�
		
		
		sqlSession.delete("com.kaishengit.mapper.UserMapper.delById",5);
		
		
		//5.�ύ����
		sqlSession.commit();
		
		//6. �ر�sqlSession
		sqlSession.close();
		
		
	}

}
