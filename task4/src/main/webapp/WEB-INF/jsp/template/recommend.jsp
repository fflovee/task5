<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 59200
  Date: 2019/6/20
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<tiles:insertAttribute name="head"/>

<body>
<tiles:insertAttribute name="header"/>


<main>
    <div class="banner">
    </div>
    <div class="container">
        <div class="subnet">首页><a href="" class="qiye">合作企业</a></div>
        <div class="row">
            <tiles:insertAttribute name="menu"/>
            <tiles:insertAttribute name="body1"/>
        </div>
    </div>
</main>
<tiles:insertAttribute name="footer"/>

</body>

<%--<head>--%>
<%--<meta charset="UTF-8">--%>
<%--<meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--<meta http-equiv="X-UA-Compatible" content="ie=edge">--%>
<%--<title>Document</title>--%>
<%--<link rel="stylesheet" href="/view/css/task14.2/task14.2.css">--%>
<%--</head>--%>
