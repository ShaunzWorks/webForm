<%@ include file="../common/common.jsp"%>
<html lang="en">
  <body>
  		<h2 class="sub-header">System Log</h2>
        <br/>
        <div class="table-responsive">
          <table id="table" class="table table-striped" style="width:100%">
          </table>
        </div>
  </body>
  	<script type="text/javascript" >
		var TableParam = {
				header:['#','<spring:message code="user.userNm"/>','Function','Opration Type','Time','Content'],
				column:['id','userId','functionId','optType','optTime','content'],
				url:'./sysLog',
				httpType:'GET',
				target:'table',
				needOpration:false
		};
		$(function(){
			Shaunz.generateTable(TableParam);
		});
	</script>
</html>
