<%--
  Created by IntelliJ IDEA.
  User: t
  Date: 2017/8/18
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>测试表单页面</title>
</head>
<body>
    ${msg}
    <form method="post" action="${path}testRepairDisplay.html">

        ${tdemotest.userName}
        <input type="text" name="userName" value="${items.userName}" /> <br>
        <input type="text" name="age" value="${items.age}" /><br>
        <input type="submit" value="提交" /><br>

    </form>

    <h2>图片上传</h2>
    <%--图片上传--%>
    <form method="post" action="${pageContext.request.contextPath}/TestController/testUploadPic.html" enctype="multipart/form-data">
        <input type="file" name="testFile"  /> <br>
        <input type="submit" value="提交" /><br>

    </form>


</body>
</html>
