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
					<li <c:if test = "${naviBar.id eq navBarId}">class="active"</c:if>>
						<c:choose>
							<c:when test="${naviBar.active eq 'active'}">
								<a href="${applicationScope.homePageObject.homeUrl}">${naviBar.name}</a>
							</c:when>
							<c:otherwise>
								<a href="${naviBar.url}?navBarId=${naviBar.id}">${naviBar.name}</a>
							</c:otherwise>
						</c:choose>
					</li>
				</c:when>
				<c:when test = "${naviBar.type eq 'dropdown'}">
					<li class="dropdown">
		               <a href="${naviBar.url}" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${naviBar.name} <span class="caret"></span></a>
		               <ul class="dropdown-menu">
		               	<c:forEach items = "${naviBar.downLists}" var = "downList">
		               		<c:choose>
								<c:when test="${downList.type eq 'normal'}">
									<li><a href="${downList.url}?dropDownLstId=${downList.id}">${downList.name}</a></li>
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
        <ul class="nav navbar-nav navbar-right">
          <li>
          	<a id="signInURL" href="${applicationScope.homePageObject.signInURL}"></a>
          </li>
        </ul>
      </div>
    </div>
</nav>
<script type="text/javascript" >
	var signInText = '<spring:message code="homepage.signin"/>';
	$('document').ready(function(){
		$.ajax({
			url: './signCheck',
			type: 'GET',
			success: function(data,status){
				if(data != null){
					var user = jQuery.parseJSON(data);
					if(user.aliasNm != null)
						$('#signInURL').html('<i class="glyphicon glyphicon-user"></i> '+user.aliasNm);
					else
						$('#signInURL').html('<i class="glyphicon glyphicon-log-in"></i> ' + signInText);
				} else {
					$('#signInURL').html(signInText);
				}
				
			},
			error: function(){
				$('#signInURL').html(signInText);
			}
		});
	});
</script>