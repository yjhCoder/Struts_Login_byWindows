<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>

<TITLE>Struts2用户登录</TITLE>
<script type="text/javascript">
	if (self != top) {
		top.location = self.location;
	}
</script>
<script type="text/javascript">
	function refresh() {
		//IE存在缓存,需要new Date()实现更换路径的作用    
		document.getElementById("image").src = "createImageAction.action?+ Math.random()"
				+ new Date();
	}
</script>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="${pageContext.request.contextPath}/css/style.css"
	type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
</HEAD>
<body>
	<center>
		<h3>用户登录</h3>
		<s:fielderror name="error" cssStyle="color:red">
		</s:fielderror>
		<s:form action="user_login.action" method="post" name="code">
			<s:textfield name="username" label="用户名" />
			<s:password name="password" label="密码" />
			<s:textfield name="checkCode" maxlength="4" label="验证码" />  
             <img id="image" border="0" onclick="refresh()"
				src="createImageAction.action" title="看不清，换一张">
			<s:submit value="登陆" />
			<s:reset value="重新输入" />
		</s:form>
	</center>
</body>
</html>
