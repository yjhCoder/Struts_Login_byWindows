package cn.yjh.dao;

import java.sql.SQLException;

import cn.yjh.domain.User;

public interface UserDao {

    User findUserByUsernameAndPassword(String username, String password) throws SQLException;
    
}
