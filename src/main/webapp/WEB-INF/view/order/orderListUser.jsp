<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "../header.jsp" %>
	<div class="container">
		<div style="height: 50px;"></div>
		<table id="orderListUserTable" class="table table-striped table-bordered" style="width:100%">
			<thead>
	            <tr>
	            	<th>Transaction ID</th>
	                <th>Product Name</th>
	                <th>Price</th>
	         		<th>Image</th>
	         		<th>Status</th>
	            </tr>
	        </thead>
			<c:forEach items="${orderList}" var="order">
				<tr>
					<td><c:out value='${order.transactionId}'/></td>
					<td><c:out value='${order.product.name}'/></td>
					<td><c:out value='${order.product.image}'/></td>
					<td><c:out value='${order.product.price}'/></td> 
					<td style="text-align: center;"><c:out value='${order.status}'/></td>
			    </tr>
			</c:forEach>

		</table>
	</div>
	<script src="${contextPath}/js/order/order.js"></script>
<%@ include file = "../footer.jsp" %>