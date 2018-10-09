<!-- Modal -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form method="PUT" modelAttribute="userForm" class="form-signin">
	<div class="modal fade" id="userModal" tabindex="-1" role="dialog" aria-labelledby="userModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<input type="hidden"  id="id" name="id"/>
			<input type="hidden"  id="password" name="password"/>
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="userModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="username">Username</label>
						<input class="form-control" id="username" name="username" type="text" placeholder="Username">
					</div>
					<div class="form-group">
						<label for="firstName">First Name</label>
						<input class="form-control" id="firstName" name="firstName" type="text" placeholder="First Name">
					</div>
					<div class="form-group">
						<label for="middleName">Middle Name</label>
						<input class="form-control" id="middleName" name="middleName" type="text" placeholder="Middle Name">
					</div>
					<div class="form-group">
						<label for="lastName">Last Name</label>
						<input class="form-control" id="lastName" name="lastName" type="text" placeholder="Last Name">
					</div>
					<div class="form-group">
						<label for="userRole">Role</label>
						<select class="form-control" id="userRole" name="userRole">
							<option value="">Select Role</option>
							<option value="<spring:message code='ROLE_ID_ADMIN' />"><spring:message code='ROLE_NAME_ADMIN'/></option>
							<option value="<spring:message code='ROLE_ID_VENDOR' />"><spring:message code='ROLE_NAME_VENDOR'/></option>
							<option value="<spring:message code='ROLE_ID_USER' />"><spring:message code='ROLE_NAME_USER'/></option>
						</select>
					</div>
					<div class="form-group" id="userShopDiv" style="display: none;">
						<label for="userShop">Shop</label>
						<select class="form-control" id="userShop" name="userShop">
							<option value="">Select Shop</option>
							<c:forEach items="${shopList}" var="shop">
								<option value="<c:out value='${shop.id}'/>"><c:out value='${shop.name}'/></option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-primary" value="Save Changes"/>
				</div>
			</div>
		</div>
	</div>
</form:form>