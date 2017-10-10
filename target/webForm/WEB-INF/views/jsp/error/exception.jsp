<%@ page language="java" contentType="text/html; charset=utf-8"  %>
<jsp:include page="../common/common.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Exception</title>
	</head>
	<body >
		<div id="exceptionShow"  ondblclick="showMsg();">  
		    	ERROR
		</div> 
	    <div id="msg" style="display:block;">  
	        	Exception: ${exception}  
	    </div>  
	</body>
	<script type="text/javascript">
		function showMsg(){
			document.getElementById("msg").style.display="block";
			
		}
	</script>
</html>