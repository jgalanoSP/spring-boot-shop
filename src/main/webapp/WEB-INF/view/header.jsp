<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title><c:out value="${pageTitle}"/></title>
	<link rel="stylesheet" href="${contextPath}/css/dataTables.bootstrap4.min.css"/>
	<link rel="stylesheet" href="${contextPath}/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="${contextPath}/css/common.css"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="${contextPath}/js/jquery-3.3.1.min.js"></script>
	<script src="${contextPath}/js/jquery.dataTables.min.js"></script>
	<script src="${contextPath}/js/dataTables.bootstrap4.min.js"></script>
	<script src="${contextPath}/js/bootstrap.min.js"></script>
</head>

<body>