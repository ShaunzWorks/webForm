<%@ include file="../common/common.jsp"%>
<html lang="en">
  <body>
  		<h2 class="sub-header">Account</h2>
  		<div class="row">
        	<div class="col-sm-3 col-md-2"><button class="btn btn-md btn-primary" onClick="openNewAccountPage()">New</button></div>
        </div>
        <br/>
        <div class="table-responsive">
          <table id="table" class="table table-striped" style="width:100%">
          </table>
        </div>
  </body>
  	<script type="text/javascript" >
		var TableParam = {
				header:['#','name','gender','email'],
				column:['id','aliasNm','gender','email'],
				needOpration:true,
				oprations:['edit','delete','view'],
				url:'./user',
				httpType:'GET',
				target:'table'
		};
		generateTable = function(param){
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
							bodyHtml += '<td></td>';
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
		}
		$(function(){
			generateTable(TableParam);
		});
		
		openNewAccountPage = function(){
			$('#FeatureContainer').load("./mngpages/account_add.html");
		}
	</script>
</html>
