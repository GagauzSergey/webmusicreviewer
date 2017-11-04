<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>webmusicreviewer</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div align="center">
    <c:url value="/newartist" var="regUrl" />

    <form action="${regUrl}" method="POST">
        Artist First Name:<br/><input type="text" name="artist_firstname"><br/>
        Artist Second Name:<br/><input type="text" name="artist_secondname"><br/>
        Artist Nickname:<br/><input type="text" name="artist_nickname"><br/>
        <input type="submit" />

        <c:if test="${exists ne null}">
            <p>Artist already exists!</p>
        </c:if>
    </form>
</div>

<a href="artist_list">Artist List</a>

</body>
</html>