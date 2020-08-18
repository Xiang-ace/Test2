package cn.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.entity.Roler;
import cn.entity.User;

public interface UserMapper {
	User login(@Param("userCode")String usercode,@Param("userPassword")String password);
	
	int modifyPassword(@Param("password")String password,@Param("id")Integer id);
	
	/*查询下拉框中的角色*/
	List<Roler> findRoler();
	
	/*查询所有用户信息*/
	List<User> findUser(@Param("userName")String userName,@Param("userRole")Integer userRole, RowBounds rowBounds);
	
	/*检测添加的用户是否存在*/
	User checkUserCode(String userCode);
	
	/*添加用户*/
	int addUser(User user);
	
	/*通过用户id查找某个用户*/
	User findUserById(Integer userId);
	
	/*修改用户信息*/
	int modifyUser(User user);
	
	/*删除用户*/
	int delUser(Integer userId);
	
	/*查看当前用户总条数*/
	int findTotalCount(@Param("userName")String userName,@Param("userRole")Integer userRole);
	
	/*修改用户头像*/
	int modifyPhoto(@Param("userPhoto")String userPhoto,@Param("id")Integer id);
	
	/*修改后显示头像框*/
	User showPhoto(Integer id);
}
