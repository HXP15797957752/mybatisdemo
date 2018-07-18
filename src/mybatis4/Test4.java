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
		//����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
		Reader reader = Resources.getResourceAsReader(resource); 
		//����sqlSession�Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//������ִ��ӳ���ļ���sql��sqlSession
		SqlSession session = sessionFactory.openSession();
		//ӳ��sql�ı�ʶ�ַ���
		String statement = "mybatis4.classMapper"+".getClass2";
		//ִ�в�ѯ����һ��Ψһuser�����sql
		Classes c = session.selectOne(statement,2);
		System.out.println(c);
		session.close();
	}

}
