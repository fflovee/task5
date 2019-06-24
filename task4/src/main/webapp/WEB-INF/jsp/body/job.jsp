<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: 59200
  Date: 2019/6/20
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main>
    <div class="container">
        <div class="subnav">首页&gt;<a href="#">职业</a></div>
        <ul class="diraction">
            方向：
            <a href="">
                <li>全部</li>
            </a>
            <a href="#web">
                <li>前端方向</li>
            </a>
            <a href="#java">
                <li>后端方向</li>
            </a>
            <a href="#qa">
                <li>QA</li>
            </a>
            <a href="#ui">
                <li>UI</li>
            </a>
        </ul>
    </div>
    <!-后端开发-->
    <div class="container">
        <div class="it-style" id="java">后端开发方向</div>
        <div class="row">
            <c:forEach items="${front}" var="f">
            <div class="col col-md-10 col-20">
                <table class="id-card">
                    <!--ios工程师-->
                    <tbody>
                    <tr>
                        <td colspan="2">
                            <div class="ios1">
                                <div class="ios-title"
                                     ${f.jobName}工程师>
                                </div>
                                <div class="ios-content">${f.description}
                                </div>
                            </div>
                        </td>
                    </tr>
                    <!--第一行-->
                    <tr>
                        <td colspan="2">
                            <div class="row-one">
                                <div class="man"></div>
                                <div class="row-one-right">
                                    <div class="row-one-title">${f.jobName}工程师</div>
                                    <div class="it-type-explain">
                                            ${fn:substring(f.description,0,65)}...
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <!--第二行-->
                    <tr>
                        <td class="row-two-left">
                            <span class="gray-word">门槛</span>
                            <c:forEach begin="1" end="${f.threshold}">
                                <img src="/view/image/task14.3/star.png">
                            </c:forEach>
                        </td>
                        <td class="row-two-right">
                            <span class="gray-word">难易程度</span>
                            <c:forEach begin="1" end="${f.difficult}">
                                <img src="/view/image/task14.3/star.png">
                            </c:forEach>
                        </td>
                    </tr>
                    <!--第三行-->
                    <tr>
                        <td class="row-two-left">
                            <span class="gray-word">成长周期</span><span class="red-word">${f.growth}</span>年
                        </td>
                        <td class="row-two-right">
                            <span class="gray-word">稀缺程度</span><span class="red-word">${f.demand}</span>家公司需要
                        </td>
                    </tr>
                    <!--第四行-->
                    <tr class="no-border">
                        <td colspan="2">
                            <table class="son-table">
                                <tbody>
                                <tr>
                                    <td rowspan="3" class="row-three-left">
                                        <span class="gray-word">薪资待遇</span>
                                    </td>
                                    <td class="row-three-right">
                                        <div>0-1年</div>
                                        <div>${f.payOne}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="row-three-right">
                                        <div>1-3年</div>
                                        <div>${f.paySec}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="row-three-right">
                                        <div>3-5年</div>
                                        <div>${f.payThr}</div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <!--第五行-->
                    <tr>
                        <td colspan="2" class="row-four">
                            有<span class="red-word">286</span>人正在学
                        </td>
                    </tr>
                    <!--第六行-->
                    <tr>
                        <td colspan="2" class="row-two-right">
                            <div class="gray-word">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            </c:forEach>

            <!--前端开发-->
            <div class="container">
                <div class="it-style" id="web">前端开发方向</div>
                <div class="row">
                    <c:forEach items="${behind}" var="b">
                    <div class="col col-md-10 col-20">
                        <table class="id-card">
                            <!--ios工程师-->
                            <tbody>
                            <tr>
                                <td colspan="2">
                                    <div class="ios1">
                                        <div class="ios-title"
                                             ${b.jobName}工程师>
                                        </div>
                                        <div class="ios-content">${b.description}
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <!--第一行-->
                            <tr>
                                <td colspan="2">
                                    <div class="row-one">
                                        <div class="man"></div>
                                        <div class="row-one-right">
                                            <div class="row-one-title">${b.jobName}工程师</div>
                                            <div class="it-type-explain">
                                                    ${fn:substring(b.description,0,65)}...
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <!--第二行-->
                            <tr>
                                <td class="row-two-left">
                                    <span class="gray-word">门槛</span>
                                    <c:forEach begin="1" end="${b.threshold}">
                                        <img src="/view/image/task14.3/star.png">
                                    </c:forEach>
                                </td>
                                <td class="row-two-right">
                                    <span class="gray-word">难易程度</span>
                                    <c:forEach begin="1" end="${b.difficult}">
                                        <img src="/view/image/task14.3/star.png">
                                    </c:forEach>
                                </td>
                            </tr>
                            <!--第三行-->
                            <tr>
                                <td class="row-two-left">
                                    <span class="gray-word">成长周期</span><span class="red-word">${b.growth}</span>年
                                </td>
                                <td class="row-two-right">
                                    <span class="gray-word">稀缺程度</span><span class="red-word">${b.demand}</span>家公司需要
                                </td>
                            </tr>
                            <!--第四行-->
                            <tr class="no-border">
                                <td colspan="2">
                                    <table class="son-table">
                                        <tbody>
                                        <tr>
                                            <td rowspan="3" class="row-three-left">
                                                <span class="gray-word">薪资待遇</span>
                                            </td>
                                            <td class="row-three-right">
                                                <div>0-1年</div>
                                                <div>${b.payOne}</div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="row-three-right">
                                                <div>1-3年</div>
                                                <div>${b.paySec}</div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="row-three-right">
                                                <div>3-5年</div>
                                                <div>${b.payThr}</div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            <!--第五行-->
                            <tr>
                                <td colspan="2" class="row-four">
                                    有<span class="red-word">286</span>人正在学
                                </td>
                            </tr>
                            <!--第六行-->
                            <tr>
                                <td colspan="2" class="row-two-right">
                                    <div class="gray-word">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    </c:forEach>

                    <%--<div class="col col-md-10 col-20">--%>
                    <%--<table class="id-card">--%>
                    <%--<!--ios工程师-->--%>
                    <%--<tbody><tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="ios2">--%>
                    <%--<div class="ios-title">--%>
                    <%--iOS工程师--%>
                    <%--</div>--%>
                    <%--<div class="ios-content">iOS是由苹果公司开发的移动操作系统，iOS与苹果的Mac OS--%>
                    <%--X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开--%>
                    <%--发人才成了国内企业必争的资源。国内 iOS开发起步相对较晚，人才培养机制--%>
                    <%--更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第一行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="row-one">--%>
                    <%--<div class="man"></div>--%>
                    <%--<div class="row-one-right">--%>
                    <%--<div class="row-one-title">Web前端工程师</div>--%>
                    <%--<div class="it-type-explain">--%>
                    <%--Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术记性产品的开发。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第二行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">门槛</span><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">难易程度</span><img src="/view/image/task14.3/star.png"><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第三行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">成长周期</span><span class="red-word"> 1-3</span>年--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">稀缺程度</span><span class="red-word"> 345</span>家公司需要--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第四行-->--%>
                    <%--<tr class="no-border">--%>
                    <%--<td colspan="2">--%>
                    <%--<table class="son-table">--%>
                    <%--<tbody><tr>--%>
                    <%--<td rowspan="3" class="row-three-left">--%>
                    <%--<span class="gray-word">薪资待遇</span>--%>
                    <%--</td>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>0-1年</div>--%>
                    <%--<div>5k-10k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>1-3年</div>--%>
                    <%--<div>10k-20k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>3-5年</div>--%>
                    <%--<div>20k-50k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第五行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-four">--%>
                    <%--有<span class="red-word">286</span>人正在学--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第六行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-two-right">--%>
                    <%--<div class="gray-word">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</div>--%>
                    <%--<div class="col col-md-10 col-20">--%>
                    <%--<table class="id-card">--%>
                    <%--<!--ios工程师-->--%>
                    <%--<tbody><tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="ios3">--%>
                    <%--<div class="ios-title">--%>
                    <%--iOS工程师--%>
                    <%--</div>--%>
                    <%--<div class="ios-content">iOS是由苹果公司开发的移动操作系统，iOS与苹果的Mac OS--%>
                    <%--X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开--%>
                    <%--发人才成了国内企业必争的资源。国内 iOS开发起步相对较晚，人才培养机制--%>
                    <%--更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第一行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="row-one">--%>
                    <%--<div class="man"></div>--%>
                    <%--<div class="row-one-right">--%>
                    <%--<div class="row-one-title">Web前端工程师</div>--%>
                    <%--<div class="it-type-explain">--%>
                    <%--Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术记性产品的开发。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第二行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">门槛</span><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">难易程度</span><img src="/view/image/task14.3/star.png"><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第三行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">成长周期</span><span class="red-word"> 1-3</span>年--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">稀缺程度</span><span class="red-word"> 345</span>家公司需要--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第四行-->--%>
                    <%--<tr class="no-border">--%>
                    <%--<td colspan="2">--%>
                    <%--<table class="son-table">--%>
                    <%--<tbody><tr>--%>
                    <%--<td rowspan="3" class="row-three-left">--%>
                    <%--<span class="gray-word">薪资待遇</span>--%>
                    <%--</td>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>0-1年</div>--%>
                    <%--<div>5k-10k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>1-3年</div>--%>
                    <%--<div>10k-20k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>3-5年</div>--%>
                    <%--<div>20k-50k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第五行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-four">--%>
                    <%--有<span class="red-word">286</span>人正在学--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第六行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-two-right">--%>
                    <%--<div class="gray-word">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</div>--%>

                    <%--<!--后端开发-->--%>
                    <%--<div class="container">--%>
                    <%--<div class="it-style" id="java">后端开发方向</div>--%>
                    <%--<div class="row">--%>
                    <%--<c:forEach items="${behind}" var="b">--%>
                    <%--<div class="col col-md-10 col-20">--%>
                    <%--<table class="id-card">--%>
                    <%--<!--ios工程师-->--%>
                    <%--<tbody><tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="ios1">--%>
                    <%--<div class="ios-title">--%>
                    <%--iOS工程师--%>
                    <%--</div>--%>
                    <%--<div class="ios-content">iOS是由苹果公司开发的移动操作系统，iOS与苹果的Mac OS--%>
                    <%--X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开--%>
                    <%--发人才成了国内企业必争的资源。国内 iOS开发起步相对较晚，人才培养机制--%>
                    <%--更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第一行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="row-one">--%>
                    <%--<div class="man"></div>--%>
                    <%--<div class="row-one-right">--%>
                    <%--<div class="row-one-title">Web前端工程师</div>--%>
                    <%--<div class="it-type-explain">--%>
                    <%--Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术记性产品的开发。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第二行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">门槛</span><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">难易程度</span><img src="/view/image/task14.3/star.png"><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第三行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">成长周期</span><span class="red-word"> 1-3</span>年--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">稀缺程度</span><span class="red-word"> 345</span>家公司需要--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第四行-->--%>
                    <%--<tr class="no-border">--%>
                    <%--<td colspan="2">--%>
                    <%--<table class="son-table">--%>
                    <%--<tbody><tr>--%>
                    <%--<td rowspan="3" class="row-three-left">--%>
                    <%--<span class="gray-word">薪资待遇</span>--%>
                    <%--</td>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>0-1年</div>--%>
                    <%--<div>5k-10k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>1-3年</div>--%>
                    <%--<div>10k-20k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>3-5年</div>--%>
                    <%--<div>20k-50k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第五行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-four">--%>
                    <%--有<span class="red-word">286</span>人正在学--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第六行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-two-right">--%>
                    <%--<div class="gray-word">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</div>--%>
                    <%--</c:forEach>--%>
                    <%--<div class="col col-md-10 col-20">--%>
                    <%--<table class="id-card">--%>
                    <%--<!--ios工程师-->--%>
                    <%--<tbody><tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="ios2">--%>
                    <%--<div class="ios-title">--%>
                    <%--iOS工程师--%>
                    <%--</div>--%>
                    <%--<div class="ios-content">iOS是由苹果公司开发的移动操作系统，iOS与苹果的Mac OS--%>
                    <%--X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开--%>
                    <%--发人才成了国内企业必争的资源。国内 iOS开发起步相对较晚，人才培养机制--%>
                    <%--更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第一行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="row-one">--%>
                    <%--<div class="man"></div>--%>
                    <%--<div class="row-one-right">--%>
                    <%--<div class="row-one-title">Web前端工程师</div>--%>
                    <%--<div class="it-type-explain">--%>
                    <%--Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术记性产品的开发。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第二行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">门槛</span><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">难易程度</span><img src="/view/image/task14.3/star.png"><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第三行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">成长周期</span><span class="red-word"> 1-3</span>年--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">稀缺程度</span><span class="red-word"> 345</span>家公司需要--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第四行-->--%>
                    <%--<tr class="no-border">--%>
                    <%--<td colspan="2">--%>
                    <%--<table class="son-table">--%>
                    <%--<tbody><tr>--%>
                    <%--<td rowspan="3" class="row-three-left">--%>
                    <%--<span class="gray-word">薪资待遇</span>--%>
                    <%--</td>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>0-1年</div>--%>
                    <%--<div>5k-10k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>1-3年</div>--%>
                    <%--<div>10k-20k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>3-5年</div>--%>
                    <%--<div>20k-50k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第五行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-four">--%>
                    <%--有<span class="red-word">286</span>人正在学--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第六行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-two-right">--%>
                    <%--<div class="gray-word">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--<!--QA-->--%>
                    <%--<div class="container">--%>
                    <%--<div class="it-style" id="qa">QA方向</div>--%>
                    <%--<div class="row">--%>
                    <%--<div class="col col-md-10 col-20">--%>
                    <%--<table class="id-card">--%>
                    <%--<!--ios工程师-->--%>
                    <%--<tbody><tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="ios3">--%>
                    <%--<div class="ios-title">--%>
                    <%--iOS工程师--%>
                    <%--</div>--%>
                    <%--<div class="ios-content">iOS是由苹果公司开发的移动操作系统，iOS与苹果的Mac OS--%>
                    <%--X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开--%>
                    <%--发人才成了国内企业必争的资源。国内 iOS开发起步相对较晚，人才培养机制--%>
                    <%--更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第一行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="row-one">--%>
                    <%--<div class="man"></div>--%>
                    <%--<div class="row-one-right">--%>
                    <%--<div class="row-one-title">Web前端工程师</div>--%>
                    <%--<div class="it-type-explain">--%>
                    <%--Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术记性产品的开发。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第二行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">门槛</span><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">难易程度</span><img src="/view/image/task14.3/star.png"><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第三行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">成长周期</span><span class="red-word"> 1-3</span>年--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">稀缺程度</span><span class="red-word"> 345</span>家公司需要--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第四行-->--%>
                    <%--<tr class="no-border">--%>
                    <%--<td colspan="2">--%>
                    <%--<table class="son-table">--%>
                    <%--<tbody><tr>--%>
                    <%--<td rowspan="3" class="row-three-left">--%>
                    <%--<span class="gray-word">薪资待遇</span>--%>
                    <%--</td>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>0-1年</div>--%>
                    <%--<div>5k-10k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>1-3年</div>--%>
                    <%--<div>10k-20k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>3-5年</div>--%>
                    <%--<div>20k-50k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第五行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-four">--%>
                    <%--有<span class="red-word">286</span>人正在学--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第六行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-two-right">--%>
                    <%--<div class="gray-word">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</div>--%>
                    <%--<div class="col col-md-10 col-20">--%>
                    <%--<table class="id-card">--%>
                    <%--<!--ios工程师-->--%>
                    <%--<tbody><tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="ios1">--%>
                    <%--<div class="ios-title">--%>
                    <%--iOS工程师--%>
                    <%--</div>--%>
                    <%--<div class="ios-content">iOS是由苹果公司开发的移动操作系统，iOS与苹果的Mac OS--%>
                    <%--X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开--%>
                    <%--发人才成了国内企业必争的资源。国内 iOS开发起步相对较晚，人才培养机制--%>
                    <%--更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第一行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="row-one">--%>
                    <%--<div class="man"></div>--%>
                    <%--<div class="row-one-right">--%>
                    <%--<div class="row-one-title">Web前端工程师</div>--%>
                    <%--<div class="it-type-explain">--%>
                    <%--Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术记性产品的开发。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第二行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">门槛</span><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">难易程度</span><img src="/view/image/task14.3/star.png"><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第三行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">成长周期</span><span class="red-word"> 1-3</span>年--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">稀缺程度</span><span class="red-word"> 345</span>家公司需要--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第四行-->--%>
                    <%--<tr class="no-border">--%>
                    <%--<td colspan="2">--%>
                    <%--<table class="son-table">--%>
                    <%--<tbody><tr>--%>
                    <%--<td rowspan="3" class="row-three-left">--%>
                    <%--<span class="gray-word">薪资待遇</span>--%>
                    <%--</td>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>0-1年</div>--%>
                    <%--<div>5k-10k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>1-3年</div>--%>
                    <%--<div>10k-20k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>3-5年</div>--%>
                    <%--<div>20k-50k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第五行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-four">--%>
                    <%--有<span class="red-word">286</span>人正在学--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第六行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-two-right">--%>
                    <%--<div class="gray-word">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</div>--%>
                    <%--<div class="col col-md-10 col-20">--%>
                    <%--<table class="id-card">--%>
                    <%--<!--ios工程师-->--%>
                    <%--<tbody><tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="ios2">--%>
                    <%--<div class="ios-title">--%>
                    <%--iOS工程师--%>
                    <%--</div>--%>
                    <%--<div class="ios-content">iOS是由苹果公司开发的移动操作系统，iOS与苹果的Mac OS--%>
                    <%--X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开--%>
                    <%--发人才成了国内企业必争的资源。国内 iOS开发起步相对较晚，人才培养机制--%>
                    <%--更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第一行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="row-one">--%>
                    <%--<div class="man"></div>--%>
                    <%--<div class="row-one-right">--%>
                    <%--<div class="row-one-title">Web前端工程师</div>--%>
                    <%--<div class="it-type-explain">--%>
                    <%--Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术记性产品的开发。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第二行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">门槛</span><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">难易程度</span><img src="/view/image/task14.3/star.png"><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第三行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">成长周期</span><span class="red-word"> 1-3</span>年--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">稀缺程度</span><span class="red-word"> 345</span>家公司需要--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第四行-->--%>
                    <%--<tr class="no-border">--%>
                    <%--<td colspan="2">--%>
                    <%--<table class="son-table">--%>
                    <%--<tbody><tr>--%>
                    <%--<td rowspan="3" class="row-three-left">--%>
                    <%--<span class="gray-word">薪资待遇</span>--%>
                    <%--</td>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>0-1年</div>--%>
                    <%--<div>5k-10k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>1-3年</div>--%>
                    <%--<div>10k-20k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>3-5年</div>--%>
                    <%--<div>20k-50k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第五行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-four">--%>
                    <%--有<span class="red-word">286</span>人正在学--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第六行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-two-right">--%>
                    <%--<div class="gray-word">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</div>--%>
                    <%--<div class="col col-md-10 col-20">--%>
                    <%--<table class="id-card">--%>
                    <%--<!--ios工程师-->--%>
                    <%--<tbody><tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="ios3">--%>
                    <%--<div class="ios-title">--%>
                    <%--iOS工程师--%>
                    <%--</div>--%>
                    <%--<div class="ios-content">iOS是由苹果公司开发的移动操作系统，iOS与苹果的Mac OS--%>
                    <%--X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开--%>
                    <%--发人才成了国内企业必争的资源。国内 iOS开发起步相对较晚，人才培养机制--%>
                    <%--更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第一行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="row-one">--%>
                    <%--<div class="man"></div>--%>
                    <%--<div class="row-one-right">--%>
                    <%--<div class="row-one-title">Web前端工程师</div>--%>
                    <%--<div class="it-type-explain">--%>
                    <%--Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术记性产品的开发。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第二行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">门槛</span><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">难易程度</span><img src="/view/image/task14.3/star.png"><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第三行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">成长周期</span><span class="red-word"> 1-3</span>年--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">稀缺程度</span><span class="red-word"> 345</span>家公司需要--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第四行-->--%>
                    <%--<tr class="no-border">--%>
                    <%--<td colspan="2">--%>
                    <%--<table class="son-table">--%>
                    <%--<tbody><tr>--%>
                    <%--<td rowspan="3" class="row-three-left">--%>
                    <%--<span class="gray-word">薪资待遇</span>--%>
                    <%--</td>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>0-1年</div>--%>
                    <%--<div>5k-10k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>1-3年</div>--%>
                    <%--<div>10k-20k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>3-5年</div>--%>
                    <%--<div>20k-50k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第五行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-four">--%>
                    <%--有<span class="red-word">286</span>人正在学--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第六行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-two-right">--%>
                    <%--<div class="gray-word">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--<!--UI-->--%>
                    <%--<div class="container">--%>
                    <%--<div class="it-style" id="ui">UI方向</div>--%>
                    <%--<div class="row">--%>
                    <%--<div class="col col-md-10 col-20">--%>
                    <%--<table class="id-card">--%>
                    <%--<!--ios工程师-->--%>
                    <%--<tbody><tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="ios1">--%>
                    <%--<div class="ios-title">--%>
                    <%--iOS工程师--%>
                    <%--</div>--%>
                    <%--<div class="ios-content">iOS是由苹果公司开发的移动操作系统，iOS与苹果的Mac OS--%>
                    <%--X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开--%>
                    <%--发人才成了国内企业必争的资源。国内 iOS开发起步相对较晚，人才培养机制--%>
                    <%--更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第一行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2">--%>
                    <%--<div class="row-one">--%>
                    <%--<div class="man"></div>--%>
                    <%--<div class="row-one-right">--%>
                    <%--<div class="row-one-title">Web前端工程师</div>--%>
                    <%--<div class="it-type-explain">--%>
                    <%--Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术记性产品的开发。--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第二行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">门槛</span><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">难易程度</span><img src="/view/image/task14.3/star.png"><img src="/view/image/task14.3/star.png">--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第三行-->--%>
                    <%--<tr>--%>
                    <%--<td class="row-two-left">--%>
                    <%--<span class="gray-word">成长周期</span><span class="red-word"> 1-3</span>年--%>
                    <%--</td>--%>
                    <%--<td class="row-two-right">--%>
                    <%--<span class="gray-word">稀缺程度</span><span class="red-word"> 345</span>家公司需要--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第四行-->--%>
                    <%--<tr class="no-border">--%>
                    <%--<td colspan="2">--%>
                    <%--<table class="son-table">--%>
                    <%--<tbody><tr>--%>
                    <%--<td rowspan="3" class="row-three-left">--%>
                    <%--<span class="gray-word">薪资待遇</span>--%>
                    <%--</td>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>0-1年</div>--%>
                    <%--<div>5k-10k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>1-3年</div>--%>
                    <%--<div>10k-20k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="row-three-right">--%>
                    <%--<div>3-5年</div>--%>
                    <%--<div>20k-50k/月</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第五行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-four">--%>
                    <%--有<span class="red-word">286</span>人正在学--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--<!--第六行-->--%>
                    <%--<tr>--%>
                    <%--<td colspan="2" class="row-two-right">--%>
                    <%--<div class="gray-word">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody></table>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</div>--%>
</main>