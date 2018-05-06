package cn.test.c3p0;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import cn.yjh.domain.User;
import cn.yjh.util.C3P0Util;

public class Test1 {

    public static User findUserByUserNameAndPassword(String username, String password) throws SQLException {
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	return qr.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class),
		username, password);
    }
    
    @Test
    public void test01() throws SQLException{
	User user = findUserByUserNameAndPassword("zhangsan", "12345");
	System.out.println(user.toString());
    }
}
