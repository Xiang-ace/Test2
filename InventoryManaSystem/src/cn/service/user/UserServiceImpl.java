package cn.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dao.user.UserMapper;
import cn.entity.Roler;
import cn.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserMapper userMapper;
	@Override
	public User login(String usercode, String password) {
		User user = userMapper.login(usercode, password);
		return user;
	}
	@Override
	public int modifyPassword(String password,Integer id) {
		int i = userMapper.modifyPassword(password, id);
		return i;
	}
	@Override
	public List<Roler> findRoler() {
		List<Roler> list = userMapper.findRoler();
		return list;
	}
	/**
	 * RowBounds是MyBatis内置的专门处理分页的类
	 */
	@Override
	public List<User> findUser(String userName, Integer userRole, int currentPage, int pageSize) {
		//偏移量，即从第几行开始读取数据，起始位为0
		int offset=(currentPage-1)*pageSize;
		//限制条数，即每页有几条数据
		int limit=pageSize;
		RowBounds rowBounds  = new RowBounds(offset, limit);
		List<User> userlist = userMapper.findUser(userName, userRole, rowBounds);
		return userlist;
	}
	@Override
	public User checkUserCode(String userCode) {
		User user = userMapper.checkUserCode(userCode);
		return user;
	}
	@Override
	public int addUser(User user) {
		int i = userMapper.addUser(user);
		return i;
	}
	@Override
	public User findUserById(Integer uid) {
		User user = userMapper.findUserById(uid);
		return user;
	}
	@Override
	public int modifyUser(User user) {
		int i = userMapper.modifyUser(user);
		return i;
	}
	@Override
	public int delUser(Integer id) {
		int i = userMapper.delUser(id);
		return i;
	}
	@Override
	public int findTotalCount(String userName, Integer userRole) {
		int totalCount = userMapper.findTotalCount(userName, userRole);
		return totalCount;
	}
	@Override
	public int modifyPhoto(String userPhoto, Integer id) {
		int i = userMapper.modifyPhoto(userPhoto, id);
		return i;
	}
	@Override
	public User showPhoto(Integer id) {
		User user = userMapper.showPhoto(id);
		return user;
	}

}
