<%--
  Created by IntelliJ IDEA.
  User: 59200
  Date: 2019/7/16
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>单图片上传</title>
</head>
<body>
<fieldset>
    <legend>图片上传</legend>
    <form action="/a/upload" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="file">
        <input type="submit" value="上传">
    </form>
</fieldset>
</body>
</html>