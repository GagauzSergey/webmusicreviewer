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
    <h1>Review List</h1>

    <c:if test="${!empty reviewList}">
        <table class="tg">
            <tr>
                <th width="80">ID</th>
                <th width="120">Review Name</th>
                <th width="120">Rate</th>
                <th width="120">Text</th>
                <!--               <th width="120">Music Relese ID</th> -->
            </tr>
            <c:forEach items="${reviewList}" var="review">
                <tr>
                    <td><a href="/newreview/${review.id}" target="_blank">${review.id}</a></td>
                    <td>${review.review_name}</td>
                    <td>${review.review_rate}</td>
                    <td>${review.review_text}</td>

                    <td><a href="<c:url value='/review/remove/${review.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <div>
        <a href="newreview">New Review</a>
    </div>
</div>
<script>
    $('.selectpicker').selectpicker();
</script>
</body>
</html>