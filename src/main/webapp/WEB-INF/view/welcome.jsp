<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "header.jsp" %>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
		
		<c:if test="${userDetails.role.name == 'ADMIN'}">
			<ul>
				<li><a href="${contextPath}/users">Users</a></li>
				<li><a href="${contextPath}/shops">Shops</a></li>		
			</ul>
		</c:if>
		<c:if test="${userDetails.role.name == 'VENDOR'}">
			<ul>
				<li><a href="${contextPath}/products">Products</a></li>
				<li><a href="${contextPath}/orders">Orders</a></li>	
			</ul>
		</c:if>
		<c:if test="${userDetails.role.name == 'USER'}">
			<ul>
				<li><a href="${contextPath}/products">Products</a></li>
				<li><a href="${contextPath}/shops">Shops</a></li>
				<li><a href="${contextPath}/shopping-cart">Shopping Cart <span class="badge badge-danger"><c:out value='${sessionScope.shoppingCart}'/></span></a></li>
				<li><a href="${contextPath}/orders">Orders</a></li>	
			</ul>
		</c:if>
    </c:if>
</div>

<%@ include file = "footer.jsp" %>