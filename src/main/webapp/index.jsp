<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/23
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style type="text/css">
      #head{
        width: 100%;
        height: 100px;
        background-color: #01AAED;
        line-height: 100px;
        text-align: center;
      }
      #body{
        width: 500px;
        height: 150px;
        border: 1px solid skyblue;
        border-radius: 8px;
        text-align: center;
        margin: 50px auto;
      }
      input{
        margin: 10px auto;
        font-size: 18px;
        height: 33px;
        width: 100px;
      }
    </style>
  </head>
  <body>
  <div id="head">
    <h1>快递e栈管理员欢迎界面</h1>
  </div>
  <div id="body">
    <h2>欢迎管理员使用</h2>
    <input type="button" value="前往登录" id="login" />
  </div>
  </body>
<script src="/js/jquery-3.5.0.min.js"></script>
<script>
  $(function () {
    $("#login").click(function () {
      location.href = "/login.do";
    });
  });

</script>
</html>
