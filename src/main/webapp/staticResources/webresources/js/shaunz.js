var Shaunz = new Object;
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
			var usrs = jQuery.parseJSON(data);
			var bodyHtml = "<tbody>";
			for(i=0;i<usrs.length;i++){
				bodyHtml += "<tr>";
				for(j=0;j<param.column.length;j++){
					bodyHtml = bodyHtml+"<td>"+usrs[i][param.column[j]]+"</td>"; 
				}
				if(TableParam.needOpration){
					bodyHtml += '<td><span class="glyphicon glyphicon-edit text-success"></span><span class="glyphicon glyphicon-remove"></span><span class="glyphicon glyphicon-zoom-in"></span></td>';
				}
				bodyHtml += "</tr>";
			}
			bodyHtml += "</tbody>";
			$('#'+param.target).html(headerHtml+bodyHtml);
			$('#'+param.target).DataTable();
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