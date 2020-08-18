package cn.service.user;

import java.util.List;

import cn.entity.Roler;
import cn.entity.User;

public interface UserService {
	User login(String usercode,String password);
	
	int modifyPassword(String password,Integer id);

	List<Roler> findRoler();
	
	List<User> findUser(String userName,Integer userRole, int currentPage, int pageSize);
	
	User checkUserCode(String userCode);
	
	int addUser(User user);
	
	User findUserById(Integer uid);
	
	int modifyUser(User user);
	
	int delUser(Integer id);
	
	int findTotalCount(String userName,Integer userRole);
	
	int modifyPhoto(String userPhoto,Integer id);
	
	User showPhoto(Integer id);
}
