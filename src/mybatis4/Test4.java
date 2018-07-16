package mybatis4;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.bean.*;

public class Test4 {
	public static void main(String[] args) throws IOException {
		String resource = "conf.xml"; 
		//加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource); 
		//构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		//映射sql的标识字符串
		String statement = "mybatis4.classMapper"+".getClass2";
		//执行查询返回一个唯一user对象的sql
		Classes c = session.selectOne(statement,2);
		System.out.println(c);
		session.close();
	}

}
