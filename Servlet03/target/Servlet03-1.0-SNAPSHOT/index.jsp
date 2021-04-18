<html>
<body>
<h2>Hello World!</h2>
<%--这里提交的路径，需要寻找项目的路径--%>
<%--jsp--%>
<form action="${pageContext.request.contextPath}/req" method="get">
    用户名：<input type="text" name="username"><br/>
    密码:<input type="text" name="password"><br/>
    <input type="submit" name="提交">
</form>
</body>
</html>