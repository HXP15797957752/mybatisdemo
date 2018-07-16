package mybatis2;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import mybatis.bean.User;
import mybatis.util.MybatisUtils;

public class Test2 {
	@Test
	public void add() throws IOException {
		String resource = "conf.xml";
		InputStream is=Test2.class.getClassLoader().getResourceAsStream(resource);
		
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		
		
		//SqlSession session = MybatisUtils.getFactory().openSession();
		
		SqlSession session=factory.openSession();
		
		String statement = "mybatis2.userMapper.addUser";
		
		int add=session.insert(statement, new User(-1,"suanzi",123));
		
		session.commit();
		
		session.close();
		
		System.err.println(add);
	}
	
	@Test
	public void delete() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		
		SqlSession  session = factory.openSession(true);
		
		String statement = "mybatis2.userMapper.deleteUser";
		
		int delete = session.delete(statement,7);
		System.out.println(delete);
		session.close();
		
	}
	
	@Test
	public void update() {
		String resource = "conf.xml";
		InputStream is = Test2.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession(true);
		String statement = "mybatis2.userMapper.updateUser";
		int update = session.update(statement, new User(1,"sss",29));
		session.close();
		System.out.println(update);
		
	}
	
	@Test
	public void getUser() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession(true);
		String statement ="mybatis2.userMapper.getUser";
		User user = session.selectOne(statement,1);
		System.out.println(user);
		session.close();
	}
	
	@Test
	public void getAllUser() {
		SqlSessionFactory factory =MybatisUtils.getFactory();
		SqlSession session =factory.openSession(true);
		String statement = "mybatis2.userMapper.getAllUsers";
		List<User> list= session.selectList(statement);
		System.out.println(list);
		session.close();
	}
}
