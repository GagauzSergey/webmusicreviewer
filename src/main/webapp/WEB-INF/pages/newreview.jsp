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
    <h1>Submit Review to Music Release</h1>
    <c:url value="/newreview" var="regUrl"/>

    <form action="${regUrl}" method="POST">
        Review Name:<br/><input type="text" name="review_name"><br/>
        Review Rate:<br/><input type= "text" name="review_rate"><br/>
        Review Text:<br/><input type="text" name="review_text"><br/>
        <!--        Music Release id:<br/><input type="text" name="musicrelease_id"><br/> -->

        <input type="submit"/>
</div>
<script>
    $('.selectpicker').selectpicker();
</script>
</body>
</html>