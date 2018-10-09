<!-- Modal -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form method="POST" class="form-signin">
	<div class="modal fade" id="shopModal" tabindex="-1" role="dialog" aria-labelledby="shopModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<input type="hidden"  id="id" name="id"/>
			<input type="hidden"  id="status" name="status"/>
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="shopModalLabel">Shop</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name">Name</label>
						<input class="form-control" id="name" name="name" type="text" placeholder="Name">
					</div>
					<div class="form-group" id="statusDiv" style="display: none;">
						<label>Status</label>
						<div style="height: 10px;"></div>
						Active? <input type="checkbox" id="statusCb" name="statusCb">
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