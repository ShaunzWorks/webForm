<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="./common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>${applicationScope.homePageObject.projectNm}</title>
	<meta name="description" content="${applicationScope.homePageObject.description}" />
	<meta name="keywords" content="${applicationScope.homePageObject.keywords}" />
	<meta name="author" content="Shaun Xiong Deng" />
	<link rel="icon" href="${projectResPath}${applicationScope.homePageObject.iconURL}">

    <!-- Bootstrap core CSS -->
    <link href="${projectResPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${projectResPath}/css/carousel.css" rel="stylesheet">
</head>
<body>
  <!-- NAVBAR================================================== -->
  <div class="navbar-wrapper">
    <div class="container">
      <nav class="navbar navbar-inverse navbar-static-top">
        <div class="container">
          <div class="navbar-header">
            <a class="navbar-brand" href="${applicationScope.homePageObject.homeUrl}">${applicationScope.homePageObject.projectNm}</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
				<c:forEach items = "${applicationScope.homePageObject.navigationBars}" var = "naviBar">
					<c:choose>
						<c:when test = "${naviBar.type eq 'normal'}">
							<li <c:if test = "${naviBar.active eq 'active'}">class="active"</c:if>>
								<a href="${naviBar.url}">${naviBar.name}</a>
							</li>
						</c:when>
						<c:when test = "${naviBar.type eq 'dropdown'}">
							<li class="dropdown">
			                <a href="${naviBar.url}" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${naviBar.name} <span class="caret"></span></a>
			                <ul class="dropdown-menu">
			                	<c:forEach items = "${naviBar.downLists}" var = "downList">
			                		<c:choose>
										<c:when test="${downList.type eq 'normal'}">
											<li><a href="${downList.url}">${downList.name}</a></li>
										</c:when>
										<c:when test="${downList.type eq 'separator'}">
											<li role="separator" class="divider"></li>
										</c:when>
										<c:when test="${downList.type eq 'dropdown_header'}">
											<li class="dropdown-header">${downList.name}</li>
										</c:when>
										<c:otherwise></c:otherwise>
									</c:choose>
			                	</c:forEach>
			                </ul>
			              </li>
						</c:when>
					</c:choose>
				</c:forEach>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  </div>
  <!-- Carousel================================================== -->
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
    	<c:forEach var = "i" begin = "1" end = "${applicationScope.homePageObject.carousels.size()}">
    		 <li data-target="#myCarousel" data-slide-to="${i}" 
    		 <c:if test = "${i == 1}">class="active"</c:if>
    		 ></li>
    	</c:forEach>
    </ol>
    <div class="carousel-inner" role="listbox">
    	<c:set var = "carouselsIndex" value = "1"/>
    	<c:forEach items = "${applicationScope.homePageObject.carousels}" var = "carousel">
    		<div class="item<c:if test = "${carouselsIndex == 1}"> active</c:if>">
    			<c:if test = "${not empty carousel.image}">
    				<img class="${carousel.image.cssClass}" src="${carousel.image.url}" alt="${carousel.image.name}">
    			</c:if>
		        <div class="container">
		          <div class="carousel-caption">
		            <h1>${carousel.header}</h1>
		            <p>${carousel.content}</p>
		            <c:if test = "${not empty carousel.button}">
		            	<p><a class="${carousel.button.cssClass}" href="${carousel.button.url}" role="button">${carousel.button.name}</a></p>
		            </c:if>
		          </div>
		        </div>
		      </div>
		    <c:set var = "carouselsIndex" value = "${carouselsIndex + 1}"/>
    	</c:forEach>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only"><spring:message code="homepage.previous"/></p></span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only"><spring:message code="homepage.next"/></p></span>
    </a>
  </div><!-- /.carousel -->
  

    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">
      <c:set var = "carouselsIndex" value = "1"/>
      	<c:forEach items = "${applicationScope.homePageObject.marketInfos}" var = "marketInfo">
      		<c:if test="${carouselsIndex % 3 == 1}"><div class="row"></c:if>
	      		<div class="col-lg-4">
		          <img class="${marketInfo.image.cssClass}" src="${marketInfo.image.url}" alt="${marketInfo.image.name}" width="140" height="140">
		          <h2>${marketInfo.header}</h2>
		          <p>${marketInfo.content}</p>
		          <p><a class="${marketInfo.button.cssClass}" href="${marketInfo.button.url}" role="button">${marketInfo.button.name} &raquo;</a></p>
		        </div><!-- /.col-lg-4 -->
	        <c:if test="${carouselsIndex % 3 == 0}"></div><!-- /.row --></c:if>
	        <c:set var = "carouselsIndex" value = "${carouselsIndex + 1}"/>
      	</c:forEach>
      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; ${applicationScope.homePageObject.systemYear} ${applicationScope.homePageObject.companyNm} &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>
    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${webResPath}/js/jquery.min.js"></script>
    <script src="${webResPath}/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${projectResPath}/js/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${projectResPath}/js/ie10-viewport-bug-workaround.js"></script>
        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${projectResPath}/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
</body>
</html>