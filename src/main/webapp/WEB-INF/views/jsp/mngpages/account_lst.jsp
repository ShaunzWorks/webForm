<%@ include file="../common/common.jsp"%>
<html lang="en">
  <body>
  		<h2 class="sub-header">Account</h2>
  		<div class="row">
        	<div class="col-sm-3 col-md-2"><button class="btn btn-md btn-primary glyphicon glyphicon-plus" onClick="openNewAccountPage()"> New</button></div>
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
				url:'./user',
				httpType:'GET',
				target:'table',
				needOpration:true,
				operations:['edit','delt','detail'],
				methods:[function(data){
					Shaunz.load("./mngpages/account_add.html");
				},
				function(data){
					console.log(data);
				},
				function(data){
					console.log(data);
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
