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
				needOpration:true,
				oprations:['edit','delete','view'],
				url:'./user',
				httpType:'GET',
				target:'table'
		};
		$(function(){
			Shaunz.generateTable(TableParam);
		});
		
		openNewAccountPage = function(){
			$('#FeatureContainer').load("./mngpages/account_add.html");
		}
	</script>
</html>
