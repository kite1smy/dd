package com.dangdang.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory ssf=null;
	//һ���߳�ʹ��һ�����ݿ����ӡ������ݿ����Ӷ�����뵽��ǰ�߳����档
	private static ThreadLocal<SqlSession> tl=new ThreadLocal<SqlSession>();
	static{
		//mybatis�������ļ�������
		String config="mybatis-config.xml";
		//�������ļ�ת����������
		InputStream is=null;
		try {
			is = Resources.getResourceAsStream(config);
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���ݿ����ӵĹ����ࡣ�������ר�������������ݿ�����
	}
	
	//�������ݿ������
	public static SqlSession getSqlSession(){
		//���Ե���ǰ�߳������ȡ���ݿ�����
		SqlSession ss=tl.get();
		//�����ȡ�������ӣ��ʹ��������ӡ�
		if(ss==null){
			ss=ssf.openSession();
			//�����ݿ����ӷ��뵱ǰ�߳��С�
			tl.set(ss);
		}
		return ss;
	}
	//�ر����ݿ���Դ
	public static void close(SqlSession sqlSession){
		if(sqlSession!=null){
			sqlSession.close();
			//�ӵ�ǰ�߳��а����ݿ������Ƴ���
			tl.remove();
		}
	}
}
