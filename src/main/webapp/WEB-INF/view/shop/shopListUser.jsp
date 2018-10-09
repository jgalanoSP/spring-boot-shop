<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "../header.jsp" %>
<div>
	Shops
	<ul>
		<c:forEach items="${shopList}" var="shop">
			<li><a href="${contextPath}/shops/<c:out value='${shop.id}'/>/products"><c:out value='${shop.name}'/></a></li>
		</c:forEach>
	</ul>
</div>
<script src="${contextPath}/js/shop/shop.js"></script>
<%@ include file = "../footer.jsp" %>