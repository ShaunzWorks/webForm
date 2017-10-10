<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="./common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>ShaunzPhotoShare</title>
	<meta name="description" content="ShaunzPhotoShare" />
	<meta name="keywords" content="ShaunzPhotoShare" />
	<meta name="author" content="Shaun Deng" />
	<link rel="shortcut icon" href="${ctxPath}/staticResources/webresources/projectResources/img/favicon.ico">
	<link rel="stylesheet" type="text/css" href="${projectResPath}/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="${projectResPath}/css/flickity.css" />
	<link rel="stylesheet" type="text/css" href="${projectResPath}/css/main.css" />
	<script src="${projectResPath}/js/modernizr.custom.js"></script>
	<!--  
	<script type="text/javascript" src="${webResPath}/js/jquery.min.js"></script>
	!--  BOOTSTRAP --
	<link rel="stylesheet" type="text/css" href="${webResPath}/css/bootstrap.min.css">
	<script type="text/javascript" src="${webResPath}/js/bootstrap.min.js"></script>
	!--  PAGINATION plugin --
	<link rel="stylesheet" type="text/css" href="${webResPath}/js/pagination/jquery.bs_pagination.min.css">
	<script type="text/javascript" src="${webResPath}/js/pagination/jquery.bs_pagination.min.js"></script>
	<script type="text/javascript" src="${webResPath}/js/pagination/bs_pagination/localization/en.min.js">
		$(function() {
		  $("#demo_pag1").bs_pagination({
		    totalPages: 100
		  });
		 
		});
	</script>
	JQUERY -->
</head>
<body>
<div id="demo_pag1"></div>
<p><spring:message code="welcome.greeting" arguments="i18nTest"/></p>
	<div class="container">
		<div class="hero">
			<div class="hero__back hero__back--static"></div>
			<div class="hero__back hero__back--mover"></div>
			<div class="hero__front"></div>
		</div>
		<header class="codrops-header">
			<div class="codrops-links">
				<a class="codrops-icon codrops-icon--prev" href="#Development/InteractiveColoringConcept/" title="Previous Demo"><span>Previous Demo</span></a>
				<a class="codrops-icon codrops-icon--drop" href="#codrops/2015/05/06/photography-website-concept/" title="Back to the article"><span>Back to the Codrops article</span></a>
			</div>
			<h1 class="codrops-title">Shaun Deng <span>Photography</span></h1>
			<nav class="menu">
				<a class="menu__item" href="#"><span>About</span></a>
				<a class="menu__item menu__item--current" href="#"><span>Work</span></a>
				<a class="menu__item" href="#"><span>Contact</span></a>
			</nav>
		</header>
		<div class="stack-slider">
			<div class="stacks-wrapper">
				<div class="stack">
					<h2 class="stack-title"><a href="#" data-text="Portraits"><span>Portraits</span></a></h2>
					<div class="item">
						<div class="item__content">
							<img src="${projectResPath}/img/type1/1.jpg" alt="img01" />
							<h3 class="item__title">Hoodie stumptown kitsch <span class="item__date">05/05/2015</span></h3>
							<div class="item__details">
								<ul>
									<li><i class="icon icon-camera"></i><span>Canon PowerShot S95</span></li>
									<li><i class="icon icon-focal_length"></i><span>22.5mm</span></li>
									<li><i class="icon icon-aperture"></i><span>&fnof;/5.6</span></li>
									<li><i class="icon icon-exposure_time"></i><span>1/1000</span></li>
									<li><i class="icon icon-iso"></i><span>80</span></li>
								</ul>
							</div>
						</div>
					</div>
					
					
				</div>
				<div class="stack">
					<h2 class="stack-title"><a href="#" data-text="Landscape"><span>Landscape</span></a></h2>
					<div class="item">
						<div class="item__content">
							<img src="${projectResPath}/img/type3/1.jpg" alt="img01" />
							<h3 class="item__title">Austin flannel salvia <span class="item__date">05/05/2015</span></h3>
							<div class="item__details">
								<ul>
									<li><i class="icon icon-camera"></i><span>Canon PowerShot S95</span></li>
									<li><i class="icon icon-focal_length"></i><span>22.5 mm</span></li>
									<li><i class="icon icon-aperture"></i><span>&fnof;/5.6</span></li>
									<li><i class="icon icon-exposure_time"></i><span>1/1000</span></li>
									<li><i class="icon icon-iso"></i><span>80</span></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="stack">
					<h2 class="stack-title"><a href="#" data-text="Miscellaneous"><span>Miscellaneous</span></a></h2>
					<div class="item">
						<div class="item__content">
							<img src="${projectResPath}/img/type2/1.jpg" alt="img01" />
							<h3 class="item__title">Chambray fingerstache <span class="item__date">05/05/2015</span></h3>
							<div class="item__details">
								<ul>
									<li><i class="icon icon-camera"></i><span>Canon PowerShot S95</span></li>
									<li><i class="icon icon-focal_length"></i><span>22.5 mm</span></li>
									<li><i class="icon icon-aperture"></i><span>&fnof;/5.6</span></li>
									<li><i class="icon icon-exposure_time"></i><span>1/1000</span></li>
									<li><i class="icon icon-iso"></i><span>80</span></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /stacks-wrapper -->
		</div>
		<!-- /stacks -->
		<img class="loader" src="${projectResPath}/img/three-dots.svg" width="60" alt="Loader image" />
	</div>
	<!-- /container -->
	<script src="${projectResPath}/js/flickity.pkgd.min.js"></script>
	<script src="${projectResPath}/js/smoothscroll.js"></script>
	<script src="${projectResPath}/js/main.js"></script>
</body>
</html>