$(function() {
    $('#usersTable').DataTable();
    
    $('.edit').click(function(e){
    	e.preventDefault();
        $('#userModal').modal();
        var id = ($(this).attr('id'));
        $.get(location+'/'+id, function(user, status) {
        	$('#id').val(user.id);
        	$('#password').val(user.password);
        	$('#username').val(user.username);
        	$('#firstName').val(user.firstName);
        	$('#middleName').val(user.middleName);
        	$('#lastName').val(user.lastName);
        	$('#userRole').val(user.role.id);
        	if(user.role.name == 'VENDOR'){
        		$('#userShopDiv').css('display','block');
        		if(user.shop != null){
        			$('#userShop').val(user.shop.id);
        		}
        	}else{
        		$('#userShop').val('');
        		$('#userShopDiv').css('display','none');
        	}
		});
    	
    });
    
    $('#userRole').change(function(e){
    	if($(this).val() == 2){
    		$('#userShop').val('');
    		$('#userShopDiv').css('display','block');
    	}else{
    		$('#userShop').val('');
    		$('#userShopDiv').css('display','none');
    	}
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