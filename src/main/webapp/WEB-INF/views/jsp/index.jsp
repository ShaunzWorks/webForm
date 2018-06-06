<%@ include file="./common/common.jsp"%>
<html>
<head>
	<%@ include file="./common/header.jsp"%>

    <!-- Bootstrap core CSS -->
    <link href="${webResPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${projectResPath}/css/carousel.css" rel="stylesheet">
</head>
<body>
  <!-- NAVBAR================================================== -->
  <div class="navbar-wrapper">
    <div class="container">
      <%@ include file="./common/navBar.jsp"%>
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
    				<c:choose>
    					<c:when test = "${fn:startsWith(carousel.image.url, '/')}">
    						<img class="${carousel.image.cssClass}" src="${ctxPath}${carousel.image.url}" alt="${carousel.image.name}">
    					</c:when>
    					<c:otherwise><img class="${carousel.image.cssClass}" src="${carousel.image.url}" alt="${carousel.image.name}"></c:otherwise>
    				</c:choose>
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
      	<c:forEach items = "${applicationScope.homePageObject.marketInfos}" var = "marketInfo" varStatus="loop">
      		<c:if test="${carouselsIndex % 3 == 1}"><div class="row"></c:if>
	      		<div class="col-lg-4">
	      			<c:choose>
    					<c:when test = "${fn:startsWith(marketInfo.image.url, '/')}">
    						<img class="${marketInfo.image.cssClass}" src="${ctxPath}${marketInfo.image.url}" alt="${marketInfo.image.name}" width="140" height="140">
    					</c:when>
    					<c:otherwise><img class="${marketInfo.image.cssClass}" src="${marketInfo.image.url}" alt="${marketInfo.image.name}" width="140" height="140"></c:otherwise>
    				</c:choose>
		          <h2>${marketInfo.header}</h2>
		          <p>${marketInfo.content}</p>
		          <p><a class="${marketInfo.button.cssClass}" href="${marketInfo.button.url}?marketInfoId=${marketInfo.id}" role="button">${marketInfo.button.name} &raquo;</a></p>
		        </div><!-- /.col-lg-4 -->
	        <c:if test="${(carouselsIndex % 3 == 0) or (loop.last)}"></div><!-- /.row --></c:if>
	        <c:set var = "carouselsIndex" value = "${carouselsIndex + 1}"/>
      	</c:forEach>
      <%@ include file="./common/copyright.jsp"%>
    </div><!-- /.container -->
</body>
</html>