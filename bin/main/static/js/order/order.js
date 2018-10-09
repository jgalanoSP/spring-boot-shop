$(function() {
    $('#orderListTable').DataTable();
    $('#orderListUserTable').DataTable();
   
    $('.edit').click(function(){
    	var id = ($(this).attr('id'));
    	$.ajax({
    		type : 'PUT',
            url : location+'/' +id,
            success: function(data) {
            	location.reload();
            }
        });
    });
    
} );