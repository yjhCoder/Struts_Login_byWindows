package cn.yjh.web.action;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.yjh.domain.User;
import cn.yjh.service.UserService;
import cn.yjh.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    private String checkCode;

    public String getCheckCode() {
	return checkCode;
    }

    public void setCheckCode(String checkCode) {
	this.checkCode = checkCode;
    }

    private UserService userService = new UserServiceImpl();

    @Override
    public User getModel() {
	return user;
    }

    /**
     * 登录
     * 
     * @param user
     * @return
     * @throws SQLException
     */
    public String login() throws SQLException {
	User u = userService.login(user);
	if (u != null) {
	    return "login";
	} else {
	    this.addFieldError("error", "用户名与密码不匹配！");
	    return "error";
	}
    }

    @Override
    public void validate() {
	HttpSession session = ServletActionContext.getRequest().getSession();

	String checkCode2 = (String) session.getAttribute("checkCode");

	if (!checkCode.equals(checkCode2)) {
	    addFieldError(checkCode, "输入的验证码有误,请重新输入");
	}
    }

}
