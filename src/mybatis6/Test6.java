package mybatis6;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import mybatis.util.MybatisUtils;

public class Test6 {
	@Test
	public void getCount() {
		SqlSession session = MybatisUtils.getFactory().openSession();
		Map<String,Integer> paramMap = new HashMap();
		paramMap.put("sex_id", 0);
		paramMap.put("user_count", -1);
		String statement = "mybaits6.userMapper.getCount";
		session.selectOne(statement, paramMap);
		Integer userCount = paramMap.get("user_count");
		System.out.println(userCount);
	}
}
