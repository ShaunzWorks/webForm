var Shaunz = new Object;
var tableIconBtn = {
		edit:'glyphicon glyphicon-edit text-success',
		detail:'glyphicon glyphicon-zoom-in',
		delt:'glyphicon glyphicon-remove'
};

Shaunz.loadPage = function(container,url){
	$(container).load(url);
};

Shaunz.load = function(url){
	return Shaunz.loadPage('#FeatureContainer',url);
}

Shaunz.treeNodeOnclick = function(target){
	var nodeId = $(target).attr('data-nodeid');
	var treeMenu = $('#TreeMenu');
	var node = treeMenu.treeview('getNode',nodeId);
	if(node.state.expanded){
		treeMenu.treeview('collapseNode',node.nodeId);
	} else {
		treeMenu.treeview('expandNode',node.nodeId);
	}
	if(node.href != "#")
		$('#FeatureContainer').load(node.href);
};

Shaunz.generateTable = function(param){
	var headerHtml = "<thead><tr>";
	for(i = 0;i<TableParam.header.length;i++){
		headerHtml += '<th>';
		headerHtml += TableParam.header[i];
		headerHtml += '</th>';
	}
	if(TableParam.needOpration){
		headerHtml += '<th>Oprations</th>';
	}
	headerHtml += "</tr></thead>";
	$.ajax({
		url:param.url,
		type: param.gethttpType,
		async: false,
		success: function(data,status){
			var objs = jQuery.parseJSON(data);
			var bodyHtml = "<tbody>";
			for(i=0;i<objs.length;i++){
				bodyHtml += "<tr>";
				for(j=0;j<param.column.length;j++){
					bodyHtml = bodyHtml+"<td>"+objs[i][param.column[j]]+"</td>"; 
				}
				if(TableParam.needOpration){
					bodyHtml += '<td>';
					var operations = TableParam.operations;
					var methods = TableParam.methods;
					bodyHtml += '<div class="row">';
					for(k=0;k<operations.length;k++){
						var operationBtnId = 'tableRow_'+objs[i].id+'_'+operations[k];
						bodyHtml += '<div id="'+operationBtnId+'" class="col-md-1"><span class="';
						bodyHtml += tableIconBtn[operations[k]];
						bodyHtml += '"></span></div> &nbsp';
						
					}
					bodyHtml += '</div>';
					bodyHtml += '</td>';
				}
				bodyHtml += "</tr>";
			}
			bodyHtml += "</tbody>";
			$('#'+param.target).html(headerHtml+bodyHtml);
			$('#'+param.target).DataTable();
			
			if(TableParam.needOpration){
				for(i=0;i<objs.length;i++){
					var methods = TableParam.methods;
					for(k=0;k<methods.length;k++){
						var operationBtnId = 'tableRow_'+objs[i].id+'_'+operations[k];
						$('#'+operationBtnId).bind('click',objs[i],methods[k]);
					}
				}
			}
		},
		error: function(e){
			console.log(e);
		}
	});
};

Shaunz.alert = function(type,title,info){
	var html = '<div class="alert alert-'+type+' alter-box" role="alert">'+
		'<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+
		'<strong>'+title+'</strong><br/> '+info+
		'</div>';
	var newDiv = $(html);
	var lastDiv = $('div:visible').last();
	if(lastDiv.hasClass('alter-box')){
		var position = lastDiv.position();
		var height = 100;
		if(lastDiv.height() > 100){
			height = lastDiv.height();
		}
		newDiv.css({top: position.top-(height+2), left: position.left});
	}
	newDiv.insertAfter(lastDiv);
	window.setTimeout(function() {
	    $(".alert").fadeTo(500, 0).slideUp(500, function(){
	        $(this).remove(); 
	    });
	}, 4000);
};

Shaunz.showSuccess = function(title,info){
	Shaunz.alert('success',title,info);
};

Shaunz.showInfo = function(title,info){
	Shaunz.alert('info',title,info);
};

Shaunz.showWarning = function(title,info){
	Shaunz.alert('warning',title,info);
};

Shaunz.showError = function(title,info){
	Shaunz.alert('danger',title,info);
};

Shaunz.submitForm = function(form,requestUrl,requestType){
	$.ajax({
			url:requestUrl,
			type:requestType,
			data:$(form).serialize(),
			success:function(data,status){
				var result = jQuery.parseJSON(data);
				if(result.result == 'success'){
					form.reset();
					Shaunz.showSuccess('Success',result.message);
				} else {
					Shaunz.showError('Error',result.message);
				}
			},
			error:function(e){
				Shaunz.showError('Error',e);
			}
		});
}