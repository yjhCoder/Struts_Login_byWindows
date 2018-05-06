package cn.yjh.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.yjh.dao.UserDao;
import cn.yjh.domain.User;
import cn.yjh.util.C3P0Util;

public class UserDaoImpl implements UserDao {

    /**
     * 查询数据库
     */
    @Override
    public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	return qr.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class),
		username, password);
    }

}
