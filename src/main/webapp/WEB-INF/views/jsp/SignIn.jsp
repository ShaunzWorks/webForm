<%@ include file="./common/common.jsp"%>
<html>
<head>
	<%@ include file="./common/header.jsp"%>

    <!-- Bootstrap core CSS -->
    <link href="${projectResPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${projectResPath}/css/carousel.css" rel="stylesheet">
    <link href="${projectResPath}/css/signin.css" rel="stylesheet">
</head>
<body>
	<div class="container">

      <form class="form-signin" onsubmit="/signIn" method="post">
        <h2 class="form-signin-heading"><spring:message code="signinpage.header"/></h2>
        <label for="inputEmail" class="sr-only"><spring:message code="signinpage.loginnm"/></label>
        <input type="email" id="inputUserNM" name="inputUserNM" class="form-control" placeholder="<spring:message code="signinpage.loginnm"/>" required autofocus>
        <label for="inputPassword" class="sr-only"><spring:message code="signinpage.pwd"/></label>
        <input type="password" id="inputPwd" name="inputPwd" class="form-control" placeholder="<spring:message code="signinpage.pwd"/>" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" id="rememberMe" value="remember-me"> <spring:message code="signinpage.rememberme"/>
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="signinpage.signin"/></button>
      </form>

    </div> <!-- /container -->
	<%@ include file="./common/jsReference.jsp"%>
</body>
</html>