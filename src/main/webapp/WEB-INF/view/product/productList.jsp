<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "../header.jsp" %>
	<div class="container">
		<div style="height: 20px;"><c:out value='${sessionScope.shopDetails.name}'/></div>
		<button type="button" class="btn btn-success" id="newProduct" style="float: right;"><i class="fa fa-plus"></i> New Product</button>
		<div style="height: 50px;"></div>
		<table id="productsTable" class="table table-striped table-bordered" style="width:100%">
			<thead>
	            <tr>
	                <th>Name</th>
	                <th>Description</th>
	                <th>Image</th>
	                <th>Price</th>
	                <th>Actions</th>
	            </tr>
	        </thead>
			<c:forEach items="${productList}" var="product">
			    <tr>
			    	<td><c:out value='${product.name}'/></td>
			        <td><c:out value='${product.description}'/></td>
			        <td><c:out value='${product.image}'/></td>
			        <td style="text-align: right;"><c:out value='${product.price}'/></td> 
			        <td style="text-align: center;">
					  	<button type="button" class="btn btn-info edit" id="<c:out value='${product.id}'/>"><i class="fa fa-edit"></i></button>
					  	<button type="button" class="btn btn-danger delete" id="<c:out value='${product.id}'/>"><i class="fa fa-trash"></i></button>
			        </td>
			    </tr>
			</c:forEach>
		</table>
	</div>
	
	<jsp:include page="productModal.jsp" />
	<script src="${contextPath}/js/product/product.js"></script>
	<%@ include file = "../footer.jsp" %>