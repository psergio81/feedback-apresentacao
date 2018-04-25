$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event){
	
	var button = $(event.relatedTarget);
	var codigoApresentacao = button.data('codigo');
	var tituloApresentacao = button.data('titulo');
	var action = button.data('action');
	
	var modal = $(this); 
	var form = modal.find('form');
	
	if(!action.endsWith('/')){
		action += '/';
	}
	
	form.attr('action', action+codigoApresentacao);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir a Apresentação <strong>'+tituloApresentacao+'</strong>?')
	
});