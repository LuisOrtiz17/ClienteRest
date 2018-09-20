$(function() {
		var Favdialog = document.getElementById('dia');
		var buttonOpen = document.getElementById('insert');
		var updateDialog = document.getElementById('datos-update');
		$('#datosPer tr').on('click', function(){
			var id = $(this).find('td:first').html();
			var name = $(this).find('td:nth-child(2)').html();
			var age = $(this).find('td:nth-child(3)').html();
			$('#update-id').val(id);
			$('#update-name').val(name);
			$('#update-age').val(age);
			updateDialog.showModal();
		});
		$('#insert').click(function(){
			Favdialog.showModal();
		});
		$('#close').click(function(){
			var close = document.getElementById('close');
			Favdialog.close();
		});
		$('#close-update').click(function(){
			var close = document.getElementById('close-update');
			updateDialog.close();
		});
		
		$('#ejecuta').click(function(e) {
			llamadaAjax();
		});

		$('#elimina').click(function(e) {
			ajaxElimina();
		});
		
		$('#inTran').click(function(e){
			ajaxAgrega();
//			var close = document.getElementById('close');
			Favdialog.close();
			refreshTable();
		});
		$('#update-send').click(function(e){
			ajaxUpdate();
			updateDialog.close();
		});
		
	});
function refreshTable(){
	var table = document.getElementById('datosPer');
	table.ajax.reload();
	//$('#table-principal').load('#datosPer');
}
	function ajaxUpdate(){
		$.ajax({
			url : '/ClienteRest/updatePer',
			type: 'POST',
			data: JSON.stringify({
				id: $('#update-id').val(),
				nombre: $('#update-name').val(),
				edad: $('#update-age').val()
			}),
			processData: false,
			contentType: "application/json",
			success: function(){
				var updateDialog = document.getElementById('datos-update');
				updateDialog.close();
			}
		});
	}
	function ajaxAgrega(){
		$.ajax({
			url : '/ClienteRest/agregaPer',
			type: 'POST',
			data: JSON.stringify({
				id: $('#insert-id').val(),
				nombre: $('#insert-name').val(),
				edad: $('#insert-age').val()
			}),
			processData: false,
			contentType: "application/json",
			success: function(){
				var Favdialog = document.getElementById('dia');
				Favdialog.close();
			}
		});
	}
	function ajaxElimina() {
		$.ajax({
			url : '/ClienteRest/eliminaPer',
			data : {
				id : $("#elim").val()
			},
			type : 'POST',
			success : function(data) {
				$('#mes').html(data);
			}
		});
	}
	function llamadaAjax() {
		$
				.ajax({
					url : '/ClienteRest/sumar',
					data : {
						num1 : $("#num1").val(),
						num2 : $("#num2").val()
					},
					type : 'POST',
					success : function(data) {
						$('#rs').html(data);
					},
					error : function(xhr, ajaxOptions, thrownError) {
						$('#rs').html(
								'Error ' + xhr.status + ": " + thrownError
										+ ".");
					}
				});
	}