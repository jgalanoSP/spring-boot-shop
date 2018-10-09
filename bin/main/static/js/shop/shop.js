$(function() {
    $('#shopsTable').DataTable();
    
    $('#newShop').click(function(){
    	$('#shopModal').modal();
    });
    
    $('.edit').click(function(e){
    	e.preventDefault();
        $('#shopModal').modal();
        $('#statusDiv').css('display','block');
        var id = ($(this).attr('id'));
        var status = '';
        $.get(location+'/'+id, function(shop, status) {
        	$('#id').val(shop.id);
        	$('#name').val(shop.name);
        	$('#status').val(shop.status);
        	
        	if(shop.status == 'ACTIVE'){
        		$('#statusCb').prop('checked', true);
        	}
		});
        
        $('#statusCb').change(function() {
			if($(this).prop('checked')){
				$('#status').val('ACTIVE');
			}else{
				$('#status').val('INACTIVE');
			}
		})
    	
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