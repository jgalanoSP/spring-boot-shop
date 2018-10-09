<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "../header.jsp" %>
<div class="container">
	<div style="height: 20px;">${sessionScope.ShoppingCart.prop}</div>
	<button type="button" class="btn btn-success" id="newShop" style="float: right;"><i class="fa fa-plus"></i> New Shop</button>
	<div style="height: 50px;"></div>
	<table id="shopsTable" class="table table-striped table-bordered" style="width:100%">
		<thead>
			<tr>
				<th>Name</th>
				<th>Status</th>
				<th>Actions</th>
			</tr>
		</thead>
		<c:forEach items="${shopList}" var="shop">
			<tr>
				<td><c:out value='${shop.name}'/></td>
				<td><c:out value='${shop.status}'/></td> 
				<td style="text-align: center;">
					<button type="button" class="btn btn-info edit" id="<c:out value='${shop.id}'/>"><i class="fa fa-edit"></i></button>
					<button type="button" class="btn btn-danger delete" id="<c:out value='${shop.id}'/>"><i class="fa fa-trash"></i></button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<jsp:include page="shopModal.jsp" />
<script src="${contextPath}/js/shop/shop.js"></script>
<%@ include file = "../footer.jsp" %>