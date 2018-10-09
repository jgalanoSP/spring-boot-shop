<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "../header.jsp" %>
<div class="container">
	<div style="height: 20px;"></div>
	<table id="usersTable" class="table table-striped table-bordered" style="width:100%">
		<thead>
			<tr>
				<th>Username</th>
				<th>Full Name</th>
				<th>Role</th>
				<th>Shop</th>
				<th>Actions</th>
			</tr>
		</thead>
		<c:forEach items="${userList}" var="user">
			<tr>
				 <td><c:out value='${user.username}'/></td>
				<td><c:out value='${user.firstName} ${user.middleName} ${user.lastName}'/></td>
				<td><c:out value='${user.role.name}'/></td>
				<c:if test="${not empty user.shop.name}">
				<td><c:out value='${user.shop.name}'/></td> 
				</c:if>
				<c:if test="${empty user.shop.name}">
				<td>N/A</td> 
				</c:if>
				<td style="text-align: center;">
				<button type="button" class="btn btn-info edit" id="<c:out value='${user.id}'/>"><i class="fa fa-edit"></i></button>
				<button type="button" class="btn btn-danger delete" id="<c:out value='${user.id}'/>"><i class="fa fa-trash"></i></button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<jsp:include page="userModal.jsp" />
<script src="${contextPath}/js/user/user.js"></script>
<%@ include file = "../footer.jsp" %>