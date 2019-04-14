package com.dangdang.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory ssf=null;
	//一个线程使用一个数据库连接。把数据库连接对象放入到当前线程里面。
	private static ThreadLocal<SqlSession> tl=new ThreadLocal<SqlSession>();
	static{
		//mybatis的配置文件的名字
		String config="mybatis-config.xml";
		//把配置文件转换成流对象
		InputStream is=null;
		try {
			is = Resources.getResourceAsStream(config);
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//数据库连接的工厂类。这个对象专门用来制作数据库连接
	}
	
	//建立数据库的链接
	public static SqlSession getSqlSession(){
		//尝试到当前线程里面获取数据库连接
		SqlSession ss=tl.get();
		//如果获取不到连接，就创建出连接。
		if(ss==null){
			ss=ssf.openSession();
			//把数据库连接放入当前线程中。
			tl.set(ss);
		}
		return ss;
	}
	//关闭数据库资源
	public static void close(SqlSession sqlSession){
		if(sqlSession!=null){
			sqlSession.close();
			//从当前线程中把数据库连接移除。
			tl.remove();
		}
	}
}
