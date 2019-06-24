<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 59200
  Date: 2019/6/20
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<main>
    <div class="banner"></div>
    <div class="container">
        <div class="subnav">首页&gt;<a href="" class="qiye">合作企业</a></div>
        <div class="row">
            <c:forEach items="${company}" var="c">
            <div class="col-lg-5 col-20">
                <div class="side-nav">
                    <div class="side-nav-title">合作企业</div>
                    <ul class="side-nav-content">
                        <li><a href="">${c.companyName}</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-15 col-20">
                <div class="potato-instrution">
                    <div class="instrution-title">
                        <div class="potato"></div>
                            ${c.history}
                    </div>
                    <div class="instrution-content">${c.introduction}
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>
</main>--%>

<div class="col-lg-15 col-20">
    <div class="potato-instrution">
        <div class="instrution-title">
                <div class="potato"></div>
                ${film.history}
        </div>
        <div class="instrution-content">
            ${film.introduction}
        </div>
    </div>
</div>
