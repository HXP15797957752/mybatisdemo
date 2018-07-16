package mybatis3;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import mybatis.bean.User;
import mybatis.util.MybatisUtils;

public class Test3 {

	@Test
	public void addTest() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession(true);
		UserMapper  mapper =session.getMapper(UserMapper.class);
		int add = mapper.add(new User(-1,"abc",59));
		System.err.println(add);
		session.close();
		
	}
}
