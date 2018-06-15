<%@ include file="../common/common.jsp"%>
<html>
<body>
	<p><h2><code><span id="currentPath"></span></code></h2></p>
	<p><b>Note:</b>If you want display below images in your blog, you should use full path to indicate the physical location of them.<br/>
	The full path of this folder is '/webForm/staticResources/customerResources/images/'<br/>
	For Example you should use it as
	<pre><code>&lt;img alt="My Image" src="/webForm/staticResources/customerResources/images/MyImage.jpg"&gt;</code></pre>
	Rather than<br/>
	<pre><code>&lt;img alt="My Image" src="MyImage.jpg"&gt;</code></pre>
	</p>
	<br/>
	<form id="imageAddForm" enctype="multipart/form-data">
		<div class="form-group">
			<input type="file" name="file" />
			<input id="fileNms" type="hidden" name="fileNms" value=""/>
			<input id="path" type="hidden" name="path" value=""/>
			<button id="upload" type="button" class="btn btn-primary glyphicon glyphicon-upload"> Upload</button>
			<button id="download" type="button" class="btn btn-primary glyphicon glyphicon-download"> Download</button>
			<button id="delete" type="button" class="btn btn-primary glyphicon glyphicon glyphicon-remove"> Delete</button>
			<button id="newFolder" type="button" class="btn btn-primary glyphicon glyphicon glyphicon-folder-open"> New Folder</button>
			<button id="refreshPage" type="button" class="btn btn-primary glyphicon glyphicon glyphicon glyphicon-repeat"> Refresh Page</button>
		</div>
	</form>
	<select class="image-picker" show-labels multiple>
	</select>
<script type="text/javascript">
var refreshPage = function(){
	$.ajax({
		url:'./file/imageLst',
		type:'GET',
		data:{'path':'/'},
		success:function(data,status){
			var rootUrl = '${ctxPath}';
			var imageLst = jQuery.parseJSON(data);
			var folderPath = "/";
			$('.image-picker').find('option').remove();
			$.each(imageLst,function(index, value){
			    var option = '<option data-img-label="'+value['name']+'" data-img-src="'+rootUrl+value['url']
			    +'" value="'+value['value']+'">'+value['value']+'</option>';
			    $(".image-picker").append(option);
			    if(index == 0){
			    	folderPath = value['folderPath'];
			    	$('#path').val(folderPath);
			    	$("#currentPath").html(folderPath);
			    }
			});
			$(".image-picker").imagepicker({
		        hide_select : true,
		        show_label: true
		    });
			var $container = $('.image_picker_selector');
		    // initialize
		    $container.imagesLoaded(function () {
		        $container.masonry({
		            columnWidth: 30,
		            itemSelector: '.thumbnail'
		        });
		    });
		},
		error:function(e){
			Shaunz.showError('Error',e);
		}
	});
}
$(function(){
	refreshPage();
	$('#upload').click(function(){
		if($('input[type="file"]')[0].files[0]){
			var fileNm = $('input[type="file"]')[0].files[0].name;
			$('#fileNm').val(fileNm);
			var formData = new FormData($('#imageAddForm')[0]);
			$.ajax({
			      url : './file/image',
			      type : 'POST',
			      data : formData,
			      cache : false,
			      contentType : false,
			      processData : false,
			      success:function(data,status){
						var result = jQuery.parseJSON(data);
						if(result.result == 'success'){
							Shaunz.showSuccess('Success',result.message);
							refreshPage();
						} else {
							Shaunz.showError('Error',result.message);
						}
					},
				error:function(e){
						Shaunz.showError('Error',e);
					}
			});
		} else {
			Shaunz.showWarning('Validation','Please choose a file first!');
		}
		
	});
	$('#download').click(function(){
		
	});
	$('#refreshPage').click(function(){
		refreshPage();
	});
});
</script>
</body>
</html>
