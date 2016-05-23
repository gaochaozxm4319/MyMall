package com.laufu.mapper;

import java.util.List;
import java.util.Map;

/*import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
*/
import com.laufu.domain.User;

public interface UserMapper {

	/*final String SELECT_ALL = "SELECT * FROM user";

	final String SELECT_BY_ID = "SELECT * FROM user WHERE id=#{id}";

	final String SELECT_BY_NAME = "SELECT * FROM user WHERE username=#{username}";

	final String INSERT = "INSERT INTO  user(id, username, password,email,roleId) values(#{id}, #{username}, #{password}, #{email},#{roleId})";

	final String UPDATE = "UPDATE  user SET username = #{username},password = #{password},email = #{email},roleId =#{roleId} WHERE id = #{id}";

	final String DELETE = "DELETE FROM user WHERE id=#{id}";

	final String SELECT_BY_PAGE_BEGIN = "SELECT * FROM user";

	final String SELECT_BY_PAGE_END = "  limit #{start}, #{max}";
	
	final String  ORDER="  ORDER BY id desc";

	final String COUNT = "SELECT COUNT(id) FROM user ";*/

	//@Insert(INSERT)
	//@Options(useGeneratedKeys = true, keyProperty = "id")  
	int addUser(User u);

//	@Update(UPDATE)
	int updateUser(User u);

	//@Delete(DELETE)
	int deleteUser(int id);

	//@Select(SELECT_BY_ID)
	User getUserById(int id);

	/**
	 * login system
	 * @param username
	 * @param password
	 * @return
	 */
	User loginSys(User u);
	
	//@Select(SELECT_BY_NAME)
	User getUserByName(String username);

	//@Select(SELECT_ALL)
	List<User> getAllUser();
	
	//@Select(SELECT_BY_PAGE_BEGIN+ORDER+SELECT_BY_PAGE_END)
	//List<User> getListUser(@Param(value="start") int start,@Param(value="max")int max);
	List<User> getListUser(Map<String, Integer> map);
	
	//@Select(COUNT)  
    int getCount();  


}
