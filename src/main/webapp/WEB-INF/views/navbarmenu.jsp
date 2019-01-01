<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="nav3">
    <nav class="navbar " role="navigation">
        <div class="container-fluid" id="menu-nav">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="/" style="color: red">WebTiengNhat</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse menucolor">
                <ul class="nav navbar-nav">
                    <li><a href="/">Trang Chủ</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Minna No<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="/minna/N5">N5</a></li>
                            <li><a href="/minna/N4">N4</a></li>
                        </ul>
                    </li>
                    <li><a href="/baiviet">Bài Viết</a></li>
                    <li><a href="#">Dịch vụ</a></li>
                    <li><a href="#">Liên hệ</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <form class="navbar-form navbar-left" role="search" method="post" action="/minna/save">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-info">Search</button>
                    </form>

                    <c:if test="${not empty pageContext.request.userPrincipal.name}">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Xin Chào:
                                ${pageContext.request.userPrincipal.name}
                                <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/admin">Admin</a></li>
                                <li>
                                    <form action="<c:url value="/j_spring_security_logout" />" method="post">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                        <button type="submit" class="btn btn-info" style="margin-left: 20px;">Logout </button>
                                    </form>
                                </li>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${ empty pageContext.request.userPrincipal.name}">
                        <li><a href="/login">Đăng Nhập</a></li>
                        <li><a href="/dangky/">Đăng Ký</a></li>
                    </c:if>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div>
    </nav>
</div>