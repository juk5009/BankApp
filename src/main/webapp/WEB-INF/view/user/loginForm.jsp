<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>로그인페이지</h1>
    <hr />
    <form action="/login" method="post" enctype="application/x-www-fomr-urlencoded">
        <input type="text" name="username" placeholder="Enter username" /><br />
        <input type="password" name="password" placeholder="Enter password" /><br />
        <button>로그인</button>
    </form>
</body>

</html>

 <%@ include file="../layout/footer.jsp" %>