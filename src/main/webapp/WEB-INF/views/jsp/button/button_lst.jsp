<%@ include file="../common/common.jsp"%>
<html lang="en">
  <body>
  		<h2 class="sub-header"><spring:message code="button.title"/></h2>
  		<div class="row">
        	<div class="col-sm-3 col-md-2"><button class="btn btn-md btn-primary glyphicon glyphicon-plus" onClick="openNewAccountPage()"> <spring:message code="common.new"/></button></div>
        </div>
        <br/>
        <div class="table-responsive">
          <table id="table" class="table table-striped" style="width:100%">
          </table>
        </div>
  </body>
  	<script type="text/javascript" >
		var TableParam = {
				header:['#','<spring:message code="button.name"/>','<spring:message code="button.url"/>','<spring:message code="button.cssclass"/>'],
				column:['id','name','url','cssClass'],
				url:'./button',
				httpType:'GET',
				target:'table',
				needOpration:true,
				operations:['detail','edit','delt'],
				methods:[function(obj){
					Shaunz.showDetail('10',obj.data.id);
				},
				function(obj){
					Shaunz.load("./button/button_edit.html?id="+obj.data.id);
				},
				function(obj){
					$.confirm({
					    title: 'Delete ' + obj.data.name +' ?',
					    autoClose: 'cancelAction|8000',
					    buttons: {
					        deleteUser: {
					            text: 'Delete',
					            action: function () {
					            	console.log(obj.data.id);
					            	Shaunz.ajaxRequest(null,'./button/'+obj.data.id,'DELETE');
									Shaunz.load("./button/button_lst.html");
					            }
					        },
					        cancelAction: function () {
					        	
					        }
					    }
					});
				}]
		};
		$(function(){
			Shaunz.generateTable(TableParam);
		});
		
		openNewAccountPage = function(){
			Shaunz.load("./button/button_add.html");
		}
		
	</script>
</html>
