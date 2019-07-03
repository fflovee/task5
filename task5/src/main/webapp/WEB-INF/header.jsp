<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <div class="container">
        <div class="row header-top align-items-center">
            <div class="col-13  customService">客服热线：010-594-78634</div>
            <div class="col-7 justify-content-right ">
                <img class="icons" src="/view/image/task14.1/qq.png">
                <img class="icons" src="/view/image/task14.1/wechat.png">
                <img class="icons" src="/view/image/task14.1/sina.png">

                <div style="line-height: 24px;margin-left: 15px;">
                <c:choose>
                    <c:when test="${name!=null}">
                        <span><a style="color: #333333;" href="#">${name}:你好</a> </span>
                        <span><a style="border-left: #999999 2px solid;padding-left:10px;color: #333333;"
                                 href="/a/logout">登出</a> </span>
                    </c:when>
                    <c:when test="${name==null}">
                        <span><a style="color: #333333;" href="/a/login">登录</a> </span>
                        <span><a style="border-left: #999999 2px solid;padding-left:10px;color: #333333;"
                                 href="/a/register">注册</a> </span>
                    </c:when>
                </c:choose>
                </div>
                <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><a style="color: #333333;" href="/a/login">登录</a> </span>
                &nbsp;&nbsp;<span><a style="border-left: #999999 1px solid;padding-left:10px;color: #333333;" href="/a/register">注册</a> </span>--%>
            </div>
        </div>
    </div>
    <div class="header-bottom">
        <div class="container">
            <div class="row align-items-center header-bottom">
                <div class="col-sm-6 col-13">
                    <div class="tree">技能树</div>
                    <div class="url">www.jnshu.com</div>
                </div>
                <div class="col-sm-14 col-7 justify-content-right">
                    <ul class="nav">
                        <a href="/a/excellence">
                            <li>首页</li>
                        </a>
                        <a href="/a/job">
                            <li>职业</li>
                        </a>
                        <a href="/a/recommend">
                            <li>推荐</li>
                        </a>
                        <a href="/a/u/vip">
                            <li>大厅</li>
                        </a>
                    </ul>

                    <button type="button">
                        <label for="boom">
                            <div class="menu">
                                <div class="line"></div>
                                <div class="line"></div>
                                <div class="line"></div>
                            </div>
                        </label>
                    </button>

                </div>
            </div>

        </div>
    </div>
    <input id="boom" type="checkbox">
    <ul class="collapsibleNav">
        <a href="##">
            <li>首页</li>
        </a>
        <a href="##">
            <li>职业</li>
        </a>
        <a href="##">
            <li>推荐</li>
        </a>
        <a href="##">
            <li>大厅</li>
        </a>
    </ul>
</header>