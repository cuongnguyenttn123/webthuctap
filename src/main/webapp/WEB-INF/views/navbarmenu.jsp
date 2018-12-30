
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="nav3">
    <nav class="navbar " role="navigation">
        <div class="container-fluid" id="menu-nav">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="/" style="color: red">CuongNguyenTTN</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse menucolor">
                <ul class="nav navbar-nav">
                    <li><a href="/">Trang Chủ</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Học Minna<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="/minna/N5">N5</a></li>
                            <li><a href="/minna/N4">N4</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Bài Viết</a></li>
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
                    <li><a href="/login">Đăng Nhập</a></li>
                    <li><a href="/login/">Đăng Ký</a></li>
                    <%--<li><a href="/login/">Xin Chào: Cuòn</a>--%>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div>
    </nav>
</div>