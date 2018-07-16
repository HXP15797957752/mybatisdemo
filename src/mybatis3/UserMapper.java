package mybatis3;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mybatis.bean.User;

public interface UserMapper {
	
	@Insert("insert into users(name,age) values(#{name},#{age})")
	public int add(User user);
	@Delete("delete from users where id=#{id}")
	public int delete();
	@Update("update users set name=#{name},age=#{age} where id=#{id}")
	public int update();
	@Select("select * from users where id=#{id}")
	public User select();
	@Select("select * from users where id=#{id}")
	public List<User> selectAll();
}
