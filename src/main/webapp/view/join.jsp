<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입창</title>
<style type="text/css">
	fieldset {
	width: 300px;
	margin: auto;
}
div{text-align: center; margin:100px; auto;}
table, th, td{
	padding: 10px; 5px;
}
input{
	padding: 5px;
}
</style>
<script type="text/javascript">
function join_Ok(f) {
	f.action="${pageContext.request.contextPath}/MyController?cmd=join_ok";
	f.submit();
}
</script>
</head>
<body>
	<div>
		<form method="post">
			<fieldset>
				<legend>회원가입</legend>
				<table>
				<tbody>
					<tr>
						<th>**ID</th><td><input type="text" name="id" placeholder="id 입력" required></td>
					</tr>
					<tr>
						<th>**PW</th><td><input type="password" name="pwd" placeholder="pw 입력" required></td>
					</tr>
				</tbody>
					<tfoot>
						<tr><td colspan="2"> <input type="button" value="회원가입" onclick="join_Ok(this.form)"></td></tr>
											 
					</tfoot>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>