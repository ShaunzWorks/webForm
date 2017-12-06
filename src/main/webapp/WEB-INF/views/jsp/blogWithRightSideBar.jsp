<%@ include file="./common/common.jsp"%>
<html>
<head>
	<%@ include file="./common/header.jsp"%>

    <!-- Bootstrap core CSS -->
    <link href="${projectResPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${projectResPath}/css/carousel.css" rel="stylesheet">
</head>
<body>
  <div class="navbar-wrapper">
    <div class="container">
      <%@ include file="./common/navBar.jsp"%>
      <div class="row">

        <div class="col-sm-8 blog-main">
        	<c:forEach items = "${blogs}" var = "blog">
				<c:choose>
					<c:when test="${blog.headerType eq 'h1'}">
						<h1 class="blog-title">${blog.header}</h1>
					</c:when>
					<c:otherwise>
						<${blog.headerType} class="blog-post-title">${blog.header}</${blog.headerType}>
					</c:otherwise>
				</c:choose>
				<c:if test = "${not empty blog.postTime}">
					<p class="blog-post-meta">${blog.postTime} by 
					<c:if test = "${not empty blog.author}">
						<a href="#">${blog.author.aliasNm}</a>
					</c:if>
					</p>
				</c:if>
				${blog.content}
	      </c:forEach>
        </div>
        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
          <div class="sidebar-module sidebar-module-inset">
            <h4>About</h4>
            <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
          </div>
          <div class="sidebar-module">
            <h4>Archives</h4>
            <ol class="list-unstyled">
              <li><a href="#">March 2014</a></li>
              <li><a href="#">February 2014</a></li>
              <li><a href="#">January 2014</a></li>
              <li><a href="#">December 2013</a></li>
              <li><a href="#">November 2013</a></li>
              <li><a href="#">October 2013</a></li>
              <li><a href="#">September 2013</a></li>
              <li><a href="#">August 2013</a></li>
              <li><a href="#">July 2013</a></li>
              <li><a href="#">June 2013</a></li>
              <li><a href="#">May 2013</a></li>
              <li><a href="#">April 2013</a></li>
            </ol>
          </div>
          <div class="sidebar-module">
            <h4>Elsewhere</h4>
            <ol class="list-unstyled">
              <li><a href="#">GitHub</a></li>
              <li><a href="#">Twitter</a></li>
              <li><a href="#">Facebook</a></li>
            </ol>
          </div>
        </div><!-- /.blog-sidebar -->
      </div>
      <%@ include file="./common/copyright.jsp"%>
    </div>
  </div>
	<%@ include file="./common/jsReference.jsp"%>
</body>
</html>