package mybatis7;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import mybatis.bean.CUser;
import mybatis.util.MybatisUtils;
import mybatis3.UserMapper;

public class Test7 {
	public static void main(String[] args) {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession(true);
		String statement ="mybatis7.userMapper.getUser";
		CUser user = session.selectOne(statement, 1);
		System.out.println(user);
		//session.clearCache();
		session.update("mybatis7.userMapper.updateUser", new CUser(2,"user",2));
		user = session.selectOne(statement, 1);
		System.out.println(user);
		session.close();
	}
	
	@Test
	public void testCache() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session1 = factory.openSession(true);
		SqlSession session2 = factory.openSession(true);
		String statement ="mybatis7.userMapper.getUser";
		CUser user = session1.selectOne(statement, 1);
		session1.commit();
		System.out.println("user"+user);
		user = session2.selectOne(statement, 1);
		session2.commit();
		System.out.println("user2"+user);
		
		
	}
	
}
