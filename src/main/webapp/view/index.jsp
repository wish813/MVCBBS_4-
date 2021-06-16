<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function login_go(f) {
	f.action="${pageContext.request.contextPath}/MyController?cmd=login";
	f.submit();
}
function join_go(f) {
	f.action="${pageContext.request.contextPath}/MyController?cmd=join";
	f.submit();	
}
</script>
</head>
<body>
	<div>
		<form method="post">
			<fieldset>
				<legend>로그인</legend>
				<p>아이디 : <input type="text" name="id" placeholder="id를 입력하세요" required></p>
				<p>패스워드 : <input type="password" name="pwd" placeholder="pw를 입력하세요" required></p>
				<input type="button" value="로그인" onclick="login_go(this.form)">&nbsp;&nbsp;&nbsp;
				<input type="button" value="회원가입" onclick="join_go(this.form)">
			</fieldset>
		</form>
	</div>
</body>
</html>