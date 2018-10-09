$(function() {
    $('#shopProductsTable').DataTable();
    $('.addTocart').click(function(){
    	$.ajax({
			type : 'POST',
			data: {'productId': $(this).attr('id'), 'transactionId': $('#transactionId').val()},
	        url : contextPath + '/add-to-cart',
	        success: function(data) {
	        	alert("Sucessfully added to cart!");
	        },
	        error: function(data){
	        	alert("Error!");
	        }
    	});
    });
    
    $('.delete').click(function(){
    	var id = ($(this).attr('id'));
    	$.ajax({
    		type : 'DELETE',
            url : window.location+'/' +id,
            success: function(data) {
            	location.reload();
            }
        });
    });
    
    $('.checkout').click(function(){
    	var transactionId = ($(this).attr('id'));
    	$.ajax({
			type : 'PUT',
			url : location+'/checkout/' + transactionId,
	        success: function(data) {
	        	alert("Success checkout!");
	        	location.reload();
	        },
	        error: function(data){
	        	alert("Error!");
	        }
    	});
    });
    
} );