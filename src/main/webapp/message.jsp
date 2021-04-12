<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/28
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #head{
            width: 100%;
            height: 100px;
            background-color: #01AAED;
            line-height: 100px;
            text-align: center;
        }
        #body{
            width: 800px;
            height: 200px;
            border: 1px solid skyblue;
            border-radius: 8px;
            text-align: center;
            margin: 50px auto;
        }
        input{
            margin: 30px auto;
            font-size: 18px;
            height: 33px;
            width: 100px;
        }
    </style>
</head>
<body>
    <div id="head">
        <h1>快递e栈错误界面提示</h1>
    </div>
    <div id="body">
        <h2>您的权限不足，无法访问改地址，请点击下方按钮进行身份登录</h2>
        <input type="button" value="前往登录" id="login" />
    </div>
</body>
<script src="/js/jquery-3.5.0.min.js"></script>
<script>
    $(function () {
        $("#login").click(function () {
            location.href = "/admin/login.html";
        });
    });
</script>
</html>
