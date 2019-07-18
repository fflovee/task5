<%--
  Created by IntelliJ IDEA.
  User: 59200
  Date: 2019/6/27
  Time: 2:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<div style="background-color: #F5F5F5;padding: 100px 0 100px 0;height: 600px;display:flex;justify-content: space-around">
    <div>
        <img src="/view/image/login-ad_03.png">
    </div>
    <div style="background-color: #ffffff;border: 1px solid #999999;width: 399px;height: 450px;display: flex;justify-content: center">

        <form action="/register" method="get">
            <div style="color: #29b078;margin: 10px 10px;text-align: center">
                <h2>用户注册</h2>
                <div style="margin-bottom: 20px;margin-top: 20px">
                    <input style="height: 50px;width: 250px;font-size: large" type="text" name="username"
                           placeholder="请输入注册用户名">
                </div>
                <div style="margin-bottom: 20px">
                    <input style="height: 50px;width: 250px;font-size: large" type="password" name="password"
                           placeholder="请输入登陆密码">
                </div>
                <div style="margin-bottom: 20px">
                    <input id="tel" style="height: 50px;width: 194px;font-size: large" type="text" name="phoneNum"
                           placeholder="请输入手机/邮箱">
                    <button id="btn">点击发送</button>
                </div>
                <div style="margin-bottom: 20px">
                    <input style="height: 50px;width: 250px;font-size: large" type="text" name="vcode"
                           placeholder="请输入验证码">
                </div>
                &lt;%&ndash;                <div style="margin: 10px 0 0 10px;"><strong>${msg}</strong></div>
                                <div style="margin: 10px 0 0 10px;"><strong>${mobile}</strong></div>&ndash;%&gt;
                <div style="margin-top: 20px">
                    <!--<input  type="submit" value="登陆" style="width: 120px;height: ">-->
                    <button style="width: 250px;height: 50px;background-color: #29b078;color: white;font-size: large"
                            type="submit">
                        提&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;交
                    </button>
                </div>
                <div style="margin: 10px 10px 0 180px"><a style="font-size: small;color: #999999" href="/login">返回登录</a>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    var btn = document.getElementById('btn')
    btn.addEventListener('click', function (e) {
        e.preventDefault();
        var xmlhttp = new XMLHttpRequest()
        var tel = document.getElementById("tel").value
        var data = 'phoneNum=' + tel
        console.log(data)
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                console.log('ok')
            }
        }
        xmlhttp.open("POST", "${pageContext.servletContext.contextPath}/a/sendSms", true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.send(data);
    })
</script>--%>
<%--function x() {--%>
<%--var xmlhttp = new XMLHttpRequest()--%>
<%--var tel = document.getElementById("tel").value--%>
<%--var data = 'phoneNum=' + tel--%>
<%--console.log(data)--%>
<%--xmlhttp.onreadystatechange = function () {--%>
<%--if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {--%>
<%--console.log('okk')--%>
<%--}--%>
<%--}--%>
<%--xmlhttp.open("POST", "${pageContext.servletContext.contextPath}/a/sendSms", true);--%>
<%--xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");--%>
<%--xmlhttp.send(data);--%>
<%--}--%>

<div style="background-color: #F5F5F5;padding: 100px 0 200px 0;height: 600px;display:flex;justify-content: space-around">
    <div>
        <img src="/view/image/login-ad_03.png">
    </div>
    <div style="background-color: #ffffff;border: 1px solid #999999;width: 400px;height: 480px;display: flex;justify-content: center">
        <form action="/a/register" method="post">
            <div style="color: #29b078;margin: 10px 10px;text-align: center">
                <h2>邮箱注册</h2>
                <%--<a href="/a/sendSms">使用用户手机注册</a></div>--%>
                <div style="margin-bottom: 20px;margin-top: 20px">
                    <input style="height: 50px;width: 250px;font-size: large" type="text" name="username" value="${username}"
                           placeholder="请输入注册用户名">
                </div>
                <div style="margin-bottom: 20px">
                    <input style="height: 50px;width: 250px;font-size: large" type="password" name="password"
                           placeholder="请输入登陆密码">
                </div>
                <div style="margin-bottom: 20px">
                    <input id="mobile" style="height: 50px;width: 190px;font-size: large" type="text" name="phoneNum"
                           value="${mobile}" placeholder="请输入手机号/邮箱">
                    <button onclick="x()">点击发送<br>${mobile_msg}</button>
                </div>
                <div style="margin-bottom: 20px">
                    <input style="height: 50px;width: 250px;font-size: large" type="text" name="code" value="${code}"
                           placeholder="请输入验证码">
                </div>
                <div style="margin: 10px 0 0 10px;"><strong>${msg}</strong></div>
                <%--<div style="margin: 10px 0 0 10px;"><strong>${message}</strong></div>--%>
                <div style="margin-top: 20px">
                    <!--<input  type="submit" value="登陆" style="width: 120px;height: ">-->
                    <button style="width: 250px;height: 50px;background-color: #29b078;color: white;font-size: large"
                            type="submit">
                        提&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;交
                    </button>
                </div>
                <div style="margin: 10px 10px 0 180px"><a style="font-size: small;color: #999999"
                                                          href="/a/login">返回登录</a>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function x() {
        var xmlhttp = new XMLHttpRequest()
        var mobile = document.getElementById("mobile").value
        var data = 'phoneNum=' + mobile
        console.log(data)
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                console.log('ok')
            }
        }
        xmlhttp.open("POST", "${pageContext.servletContext.contextPath}/a/sendSms", true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.send(data);
    }
</script>