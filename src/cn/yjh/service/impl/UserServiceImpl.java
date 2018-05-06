package cn.yjh.service.impl;

import java.sql.SQLException;

import cn.yjh.dao.UserDao;
import cn.yjh.dao.impl.UserDaoImpl;
import cn.yjh.domain.User;
import cn.yjh.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    
    @Override
    public User login(User user) throws SQLException {
	return userDao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

}
