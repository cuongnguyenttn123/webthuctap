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
    <script type="text/javascript" src="../../resources/ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="../../resources/ckfinder/ckfinder.js"></script>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <textarea name="cuongnguyen" id="editor" cols="30" rows="10"></textarea>
    <input type="submit" value="Submit">
</form>
<script>
    var editor = CKEDITOR.replace('editor');
    CKFinder.setupCKEditor(editor, 'resources/ckfinder/');
</script>
</body>
</html>
