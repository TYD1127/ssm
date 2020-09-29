<%--
  Created by IntelliJ IDEA.
  User: TYD
  Date: 2020/9/27
  Time: 17:28
 新增用户注册
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>用户注册</title>
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="favicon.ico" rel="shortcut icon"/>
    <script type="text/javascript">
    //     function a() {
    //         var pd=document.getElementById("upwd");
    //         if(pd.value==""){
    //             alert(" 密码不能为空！");
    //             return false;
    //         }
    //         return true;
    // }

        function checkuName() {
            $.post({
                // type:"POST",   //http请求方式
                url: "${pageContext.request.contextPath}/regcheckName", //发送给服务器的url
                data: {"uname": $("#uname").val()}, //发送给服务器的参数
                success: function (data) {
                    if ("ok"!== data.toString()) {
                        $('#uInfo').css("color", "red");
                    } else {
                        $('#uInfo').css("color", "green");
                    }
                    $("#uInfo").html(data);
                }
            });
        }
    </script>
  </head>

<body style=" margin: 0 auto; height: 40%; width: 40%; background: url(https://cn.bing.com/th?id=OHR.FraserRiver_ZH-CN1625992097_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp) no-repeat center center fixed; background-size: 100%;">
<div class="modal-content" id="model-body" style="margin-top: 30%;background: #FFFFFF">
    <div class="modal-header">
        <h4 class="modal-title text-center" id="myModalLabel">欢迎加入</h4>
    </div>
    <form name="form" action="${pageContext.request.contextPath}/regController" method="post" style="margin-left: 10%">
        <div class="form-group row ">
            <label for="uname" class="col-sm-2 col-form-label"> 用户名：
            </label>
            <div class="col-sm-10">
                <input type="text" name="uname" id="uname" class="form-control" placeholder="请设置用户名" autocomplete="off" onblur="checkuName()">
                <span id="uInfo"></span>
            </div>
        </div>


        <div class="form-group row">
            <label for="upwd" class="col-sm-2 col-form-label"> 密 码：
            </label>
            <div class="col-sm-10">
                <input type="password" id="upwd" name="upwd" class="form-control" placeholder="请设置密码" autocomplete="off" onblur="a()">
            </div>

        </div>
        <div class="form-group" style="margin-left: 60%">
            <button type="submit" class="btn btn-primary form-control" style="font-family:SimSun-ExtB">立即注册</button>
            <span >${msg}</span>
        </div>
    </form>
    <div class="group" style="margin-left: 60%" >
        <button  class="btn btn-default form-control" herf="/backed" style="background:rgba(35,12,255,0) ;">返回登陆</button>
    </div>
</div>
</body>
</html>
