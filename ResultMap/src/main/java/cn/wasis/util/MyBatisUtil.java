package com.kaishengit.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	/**
	 * SqlSessionFactory ��̬������ϵͳ������ʱֻ��һ��(����)
	 */
	private static SqlSessionFactory sessionFactory = builderSessionFactory();

	private static SqlSessionFactory builderSessionFactory() {
		try {
			//1. ���������ļ�
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			//2. ����SqlSessionFactory
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			return sqlSessionFactoryBuilder.build(reader);
		} catch (IOException e) {
			throw new RuntimeException("��ȡMyBaits�����ļ��쳣",e);
		}
	}
	
	/**
	 * ��ȡSqlSessionFactory
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * ��ȡSqlSession
	 * @return
	 */
	public static SqlSession getSqlSession() {
		return getSqlSessionFactory().openSession();
	}
	
}
