<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/one" method="post">
    用户名：<input type="text" name="username"><br/>
    密码:<input type="text" name="password"><br/>
    爱好：
        <input type="checkbox" name="booddys" value="女孩">女孩
        <input type="checkbox" name="booddys" value="代码">代码
        <input type="checkbox" name="booddys" value="酒吧">酒吧
        <input type="checkbox" name="booddys" value="睡觉">睡觉
        <input type="checkbox" name="booddys" value="上班">上班<br/>
    <input type="submit" name="提交">
</form>
</body>
</html>
