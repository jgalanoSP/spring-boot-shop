<!-- Modal -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form method="POST" class="form-signin">
	<div class="modal fade" id="productModal" tabindex="-1" role="dialog" aria-labelledby="productModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<input type="hidden"  id="id" name="id"/>
			<input type="hidden"  id="shopId" name="shopId" value="${sessionScope.shopDetails.id}"/>
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="shopModalLabel">Product</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name">Name</label>
						<input class="form-control" id="name" name="name" type="text" placeholder="Name">
					</div>
					<div class="form-group">
						<label for="price">Price</label>
						<input class="form-control" id="price" name="price" type="text" placeholder="Price">
					</div>
					<div class="form-group">
						<label for="description">Description</label>
						<input class="form-control" id="description" name="description" type="text" placeholder="Description">
					</div>
					<div class="form-group">
						<label for="image">Image</label>
						<input class="form-control" id="image" name="image" type="text" placeholder="Image">
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