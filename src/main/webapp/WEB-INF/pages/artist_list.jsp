<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>webmusicreviewer</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<h1>Artist List</h1>

<c:if test="${!empty artistList}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Artist nickname </th>
        </tr>
        <c:forEach items="${artistList}" var="artist">
            <tr>
                <td><a href="/newartist/${artist.id}" target="_blank">${artist.id}</a></td>
                <td>${artist.artist_nickname}</td>
                <td><a href="<c:url value='/remove/${artist.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<a href="newartist">New Artist</a>
</body>
</html>