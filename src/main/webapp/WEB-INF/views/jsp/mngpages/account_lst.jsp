<%@ include file="../common/common.jsp"%>
<html lang="en">
  <body>
  		<h2 class="sub-header"><spring:message code="user.title"/></h2>
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
				header:['#','<spring:message code="user.userNm"/>','<spring:message code="user.gender"/>','<spring:message code="user.email"/>'],
				column:['id','aliasNm','gender','email'],
				url:'./user',
				httpType:'GET',
				target:'table',
				needOpration:true,
				operations:['detail','edit','delt'],
				methods:[function(obj){
					
				},
				function(obj){
					Shaunz.load("./mngpages/account_edit.html?id="+obj.data.id);
				},
				function(obj){
					Shaunz.ajaxRequest(null,'./user/'+obj.data.id,'DELETE');
					Shaunz.load("./mngpages/account_lst.html");
				}]
		};
		$(function(){
			Shaunz.generateTable(TableParam);
		});
		
		openNewAccountPage = function(){
			Shaunz.load("./mngpages/account_add.html");
		}
	</script>
</html>
