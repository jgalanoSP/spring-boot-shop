<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file = "../header.jsp" %>
	<div class="container">
		<div style="height: 50px;"></div>
		<table id="orderListTable" class="table table-striped table-bordered" style="width:100%">
			<thead>
	            <tr>
	                <th>Product Name</th>
	                <th>Price</th>
	                <th>Description</th>
	         		<th>Image</th>
	         		<th>Action</th>
	            </tr>
	        </thead>
	        <c:if test='${sessionScope.shoppingCart > 0}'>
				<c:forEach items="${shoppingCartList}" var="cart">
				    <tr>
				    	<c:set var="priceTotal" value="${priceTotal + cart.product.price}"/>
				    	<td><c:out value='${cart.product.name}'/></td>
				        <td style="text-align: right;"><fmt:formatNumber value="${cart.product.price}" type="currency" currencySymbol=""/></td> 
				        <td><c:out value='${cart.product.description}'/></td>
				        <td><c:out value='${cart.product.image}'/></td>
				        <td style="text-align: center;">
						  	<button type="button" class="btn btn-danger delete" id="<c:out value='${cart.id}'/>"><i class="fa fa-trash"></i></button>
				        </td>
				    </tr>
				</c:forEach>
				<tr>
					<td colspan="5" style="text-align: right">Total price: <fmt:formatNumber value="${priceTotal}" type="currency" currencySymbol=""/></td>
				</tr>
				<tr>
					<td colspan="5" style="text-align: right">
						<button type="button" class="btn btn-info checkout" id="<c:out value='${shoppingCartList[0].transactionId}'/>">Checkout</button>
					</td>
				</tr>
			</c:if>
			<c:if test='${sessionScope.shoppingCart == 0}'>
				<tr>
					<td colspan="5" style="text-align: center;">No data available.</td>
				</tr>
			</c:if>
		</table>
	</div>
	<script src="${contextPath}/js/order/shoppingCart.js"></script>
<%@ include file = "../footer.jsp" %>