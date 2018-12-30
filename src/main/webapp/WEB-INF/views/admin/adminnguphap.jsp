<%--
  Created by IntelliJ IDEA.
  User: cuong
  Date: 12/11/2018
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--<script type="text/javascript" src="../../resources/ckeditor/ckeditor.js"></script>--%>
    <script type="text/javascript" src="<c:url value="/resources/ckeditor/ckeditor.js"/>"></script>
    <title>Thêm Ngữ Pháp</title>
</head>
<body>
    <form action="/admin/minna/nguphap/themnguphap/${idBaiHoc}" method="post">
        <label for="tenNguPhap">Tên Ngữ Pháp: </label>
        <input class="form-control" name="tenNguPhap" id="tenNguPhap">
        <label for="url">Nhập url: </label>
        <input class="form-control" name="url" id="url">
        <br/>
        <br/>
        <textarea name="noiDung" id="editor" cols="30" rows="10"></textarea>
        <input type="submit" value="Submit">
    </form>
<script>
    var editor = CKEDITOR.replace('editor');
    CKFinder.setupCKEditor(editor, 'resources/ckfinder/');
</script>
</body>
</html>
