<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>首页</title>
    <!-- Bootstrap core CSS -->
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="favicon.ico" rel="shortcut icon"/>
    <script type="text/javascript">
        <%--function reg() {--%>
        <%--    top.location.href='${pageContext.request.contextPath}/book/reg';--%>
        <%--}--%>

        function checkName() {
            $.post({
                // type:"POST",   //http请求方式
                url: "${pageContext.request.contextPath}/book/checkName", //发送给服务器的url
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

</head>

<body
        style=" background: url(https://cn.bing.com/th?id=OHR.FraserRiver_ZH-CN1625992097_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp) no-repeat center center fixed; background-size: 100%;">


<div class="modal-dialog" style=" width: 45%;margin-top: 10%" >
<%--    <h3 class="form-control">--%>
<%--        <a href="${pageContext.request.contextPath}/book/allBook">点击进入列表页</a>--%>
<%--    </h3>--%>

    <div class="modal-content">
        <div class="modal-header">

            <h4 class="modal-title text-center" id="myModalLabel">Welcome To SSM Test</h4>
        </div>
        <form name="login" action="${pageContext.request.contextPath}/login" method="post"
              style="margin-left: 10%">
            <div class="modal-body" id="model-body">

                <div class="form-group">

                    <input type="text" id="uname" name="uname" class="form-control" placeholder="用户名"
                           autocomplete="off"
                           onblur="checkName()">
                    <span id="uInfo"></span>
                </div>
                <div class="form-group">

                    <input type="password" id="upwd" name="upwd" class="form-control" placeholder="密码"
                           autocomplete="off">
                    <span id="pInfo"></span></p>
                </div>
            </div>
            <div style="margin-left: 30% ;margin-right: 30%">
                <div class="form-group">
                    <button type="submit" class="btn btn-primary form-control">登录</button>
                </div>
                <p>${msg}</p>
                <div class="form-group">
                    <a type="button" class="btn btn-default form-control" href="/reg">注册</a>
                </div>
            </div>
        </form>

    </div><!-- /.modal-content -->
</div><!-- /.modal -->

</body>

</body>
</html>