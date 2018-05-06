package cn.yjh.service;

import java.sql.SQLException;

import cn.yjh.domain.User;

public interface UserService {

    User login(User user) throws SQLException;

}
