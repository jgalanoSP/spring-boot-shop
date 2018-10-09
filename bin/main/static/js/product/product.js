$(function() {
    $('#productsTable').DataTable();
    
    $('#newProduct').click(function(){
    	$('#productModal').modal();
    });
    
    $('.edit').click(function(e){
    	e.preventDefault();
        $('#productModal').modal();
        var id = ($(this).attr('id'));
        $.get(location+'/'+id, function(product, status) {
        	$('#id').val(product.id);
        	$('#name').val(product.name);
        	$('#price').val(product.price);
        	$('#description').val(product.description);
        	$('#image').val(product.image);
		});
    	
    });
    
    $('.delete').click(function(){
    	var id = ($(this).attr('id'));
    	$.ajax({
    		type : 'DELETE',
            url : location+'/' +id,
            success: function(data) {
            	location.reload();
            }
        });
    });
    
} );