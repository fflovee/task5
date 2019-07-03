<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 59200
  Date: 2019/6/23
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-lg-5 col-20">
    <div class="side-nav">
        <div class="side-nav-title">合作企业</div>
        <ul class="side-nav-content">
            <c:forEach items="${list}" var="l" >
                <li><a href="/a/recommend?id=${l.id}">${l.companyName}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>