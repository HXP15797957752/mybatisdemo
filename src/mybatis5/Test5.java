package mybatis5;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.bean.ConditionUser;
import mybatis.bean.User;

public class Test5 {
	public static void main(String[] args) throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession(true);
		String statement = "mybatis5.userMapper.getUser";
		List<User> list = session.selectList(statement,new ConditionUser("%o%",1,13));
		System.out.println(list);
	}
}
