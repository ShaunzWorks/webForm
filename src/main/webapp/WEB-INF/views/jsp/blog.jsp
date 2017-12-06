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
      <%@ include file="./common/copyright.jsp"%>
    </div>
  </div>
	<%@ include file="./common/jsReference.jsp"%>
</body>
</html>