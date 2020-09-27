<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>首页</title>
    <!-- Bootstrap core CSS -->
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .main {
            background-color: #fff;
            border-radius: 20px;
            width: 350px;
            height: 350px;
            margin: auto;
            position: absolute;
            top: 50px;
            left: 0;
            right: 0;
            bottom: 0;
        }

        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

    <script type="text/javascript">

        function login() {


        }

        function checkName() {
            $.post({
                // type:"POST",   //http请求方式
                url: "${pageContext.request.contextPath}/book/a", //发送给服务器的url
                data: {"uname": $("#uname").val()}, //发送给服务器的参数
                success: function (data) {
                    if ("用户名正确" !== data.toString()) {
                        $('#uInfo').css("color", "red");
                    } else {
                        $('#uInfo').css("color", "green");
                    }
                    $("#uInfo").html(data);
                }
            });
        }
    </script>

    <style type="text/css">
        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }

        h3 {
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 4px;
        }
    </style>
</head>
<body>

<h3>
    <a href="${pageContext.request.contextPath}/book/allBook">点击进入列表页</a>
</h3>

<div class="main">
    <form class="form-inline" action="" method="post">
        <div class="form-label-group" style="margin-top: 20px">
            <p><label>用户名：</label><input type="text" id="uname" class="form-control" placeholder="请输入用户名"
                                         onblur="checkName()"/>
                <span id="uInfo"></span>
            </p>

        </div>

        <div class="form-label-group" style="margin-top: 20px">
            <p>
                <label for="upwd">密 码：</label>
                <input type="password" id="upwd" class="form-control" placeholder="请输入密码" required="">
                <span id="pInfo"></span></p>
            <%--            <label for="inputPassword"></label>--%>
        </div>

        <div class="checkbox mb-3" style="margin-top: 20px">
            <label>
                <input type="checkbox" value="remember-me"> 记住密码
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" >立即登陆</button>
    </form>
</div>
</body>
</html>