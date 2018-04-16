<%@ include file="./common/common.jsp"%>
<html lang="en">
  <head>
    <%@ include file="./common/header.jsp"%>

    <!-- Bootstrap core CSS -->
    <link href="${webResPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${projectResPath}/css/dashboard.css" rel="stylesheet">
    <link href="${webResPath}/css/bootstrap-treeview.min.css" rel="stylesheet">
    <link href="${webResPath}/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="${webResPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="${webResPath}/css/shaunz.css" rel="stylesheet">
    <%@ include file="./common/jsReference.jsp"%>
  </head>
	<script type="text/javascript" > 
		$('document').ready(function(){
			$.ajax({
				   url: './functions',
				   type: 'GET',
				   success: function(data,status) {
					   $('#TreeMenu').treeview(jQuery.parseJSON(data));
				   },
				   error: function(e) {
					   console.log(e);
				   }
				});
			$('#FeatureContainer').load('./mngpages/dashboard.html');
			Shaunz.showSuccess('test','test');
		});
	</script>
  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">${applicationScope.homePageObject.projectNm}</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
            <li><a href="./signout">Logout</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div id="TreeMenu" class="col-sm-3 col-md-2 sidebar"></div>
        <div id="FeatureContainer" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"></div>
      </div>
    </div>
  </body>
</html>
