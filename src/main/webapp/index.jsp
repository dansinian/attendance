<%--<html>
<body>
<h2>Hello World!</h2>
</body>
</html>--%>
<%--
  Created by IntelliJ IDEA.
  User: chenpeng
  Date: 2018/7/21
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/file/upload" method="post"  enctype="multipart/form-data">
    <p>选择文件:<input type="file" name="files"></p>
    <p><input type="submit" value="提交"></p>
</form>
</body>
</html>
