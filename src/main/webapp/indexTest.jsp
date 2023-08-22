<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="../resources/css/indexTest.css">
		<title>작고 소중한 털뭉치</title>
	</head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <body>
        <header>
				<div class="d-flex justify-content-around header-top-padding">
					<div>
						<form class="d-flex" role="search">
	                    	<input class="form-control" type="search" placeholder="장난감/쳇바퀴..." aria-label="Search">
	                    	<button class="btn" type="submit">
	                    		<img src="resources/image/img/glasses.png">
	                    	</button>
	                	</form>
                	</div>
					<div id="th_rightMenu">
						<ul>
							<c:if test="${sessionScope.memberId ne null}">
								<li>${sessionScope.memberName }님</li>
								<li><a href="/member/myPage.do?memberId=${sessionScope.memberId }">마이페이지</a>
									<ul>
										<li><a href="#">주문 조회</a></li>
										<li><a href="/member/logout.do">로그아웃</a></li>
									</ul>
									<li><a href="/product/cart.do">장바구니</a></li>
								</li>
							</c:if>
							<c:if test="${sessionScope.memberId eq null}">
								<li><a href="/member/login.do">로그인</a></li>
								<li><a href="/member/join.do">회원가입</a></li>
							</c:if>
							
							<li><a href="/notice/list.do">고객센터</a></li>
		
						</ul>
					</div>
				</div>
				<div class="d-none d-md-block">
					<a href="/indexTest.jsp">
						<img class="main_imgDiv" src="resources/image/img/jacksomung.png">
					</a>
				</div>
		</header>
        <nav class="navbar navbar-expand-lg">
        	<button class="navbar-toggler bg-light" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-center" id="collapsibleNavbar">
				<ul class="navbar-nav text-center">
					<li class="nav-item"><a class="nav-link" href="#">사료</a></li>
					<li class="nav-item"><a class="nav-link" href="#">간식</a></li>
					<li class="nav-item"><a class="nav-link" href="#">급수/급식기</a></li>
					<li class="nav-item"><a class="nav-link" href="#">이갈이</a></li>
					<li class="nav-item"><a class="nav-link" href="#">베딩/모래</a></li>
					<li class="nav-item"><a class="nav-link" href="#">은신처/화장실</a></li>
					<li class="nav-item"><a class="nav-link" href="/product/list.do">장난감/쳇바퀴</a></li>
					<li class="nav-item"><a class="nav-link" href="#">하우스/이동장</a></li>
				</ul>
			</div>
		</nav>
        <main class="text-center">
            <div id="carouselExample" class="carousel slide carousel-size d-none d-md-block" data-bs-ride="carousel" >
            	<!-- 눌러지지는 않지만 하단에서 몇번째 사진인지 보여줌 -->
	            <div class="carousel-indicators">
	                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
	                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
	                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
	            </div>
	            <div class="carousel-inner">
	                <div class="carousel-item active">
	                <img src="../resources/image/img/banner1.jpg" class="d-block w-100" alt="배너1">
	                </div>
	                <div class="carousel-item">
	                <img src="../resources/image/img/banner2.jpg"" class="d-block w-100" alt="배너2">
	                </div>
	                <div class="carousel-item">
	                <img src="../resources/image/img/banner3.jpg" class="d-block w-100" alt="배너3">
	                </div>
	            </div>
	            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
	                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	                <span class="visually-hidden">Previous</span>
	            </button>
	            <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
	                <span class="carousel-control-next-icon" aria-hidden="true"></span>
	                <span class="visually-hidden">Next</span>
	            </button>
        	</div>
            <div class="container">
                <h2><span>NEW ITEMS </span></h2>
                <div>
                    <img src="../resources/image/productImg/carrotDrops.jpg" alt="뉴템1" class="nt_img">
                    <img src="../resources/image/productImg/house02.png" alt="뉴템2" class="nt_img">
                    <img src="../resources/image/productImg/treadmill01.jpg" alt="뉴템3" class="nt_img">
                    <img src="../resources/image/productImg/hamster's hats.jpg" alt="뉴템4" class="nt_img">
                    <img src="../resources/image/productImg/treadmill06.png" alt="뉴템5" class="nt_img">
                </div>
            </div>
			<div class="container justify-content-center">
				<h2><span>WEEKLY BEST</span></h2>
				<div class="row ">
					<div class="col-md-6 col-lg-4 col-xl-3 bt_box" >
						<img src="../resources/image/productImg/coconut01.jpg" alt="">
						<p class="name">코코넛 은신처</p>
						<p class="price">9,000원</p>
					</div>
					<div class="col-md-6 col-lg-4 col-xl-3 bt_box">
						<img src="../resources/image/productImg/cookies01.jpg" alt="">
						<p class="name">하트쿠키</p>
						<p class="price">8,000원</p>
					</div>
					<div class="col-md-6 col-lg-4 col-xl-3 bt_box">
						<img src="../resources/image/productImg/house01.jpg" alt="">
						<p class="name">분홍 사다리 은신처</p>
						<p class="price">6,000원</p>
					</div>
					<div class="col-md-6 col-lg-4 col-xl-3 bt_box">
						<img src="../resources/image/productImg/bridge01.jpg" alt="">
						<p class="name">파스텔다리</p>
						<p class="price">6,000원</p>
					</div>
					<div class="col-md-6 col-lg-4 col-xl-3 bt_box">
						<img src="../resources/image/productImg/treadmill05.jpg" alt="">
						<p class="name">우드 쳇바퀴</p>
						<p class="price">30,000원</p>
					</div>
					<div class="col-md-6 col-lg-4 col-xl-3 bt_box">
						<img src="../resources/image/productImg/treadmill04.jpg" alt="">
						<p class="name">파랑 소저</p>
						<p class="price">15,000원</p>
					</div>
					<div class="col-md-6 col-lg-4 col-xl-3 bt_box">
						<img src="../resources/image/productImg/smakers.jpg" alt="">
						<p class="name">사과 스매커</p>
						<p class="price">16,000원</p>
					</div>
					<div class="col-md-6 col-lg-4 col-xl-3 bt_box">
						<img src="../resources/image/productImg/desertSand.jpg" alt="">
						<p class="name">사막모래</p>
						<p class="price">20,000원</p>
					</div>
					<div class="col-md-6 col-lg-4 col-xl-3 bt_box">
						<img src="../resources/image/productImg/treadmill07.jpg" alt="">
						<p class="name">블랙&화이트 쳇바퀴</p>
						<p class="price">20,000원</p>
					</div>
					<div class="col-md-6 col-lg-4 col-xl-3 bt_box">
						<img src="../resources/image/productImg/house03.jpg" alt="">
						<p class="name">개구리 은신처</p>
						<p class="price">10,000원</p>
					</div>
					<div class="col-md-6 col-lg-4 col-xl-3">
						<img src="../resources/image/productImg/sunFolwerSeed.jpg" alt="">
						<p class="name">해바라기씨</p>
						<p class="price">8,000원</p>
					</div>
				</div>
			</div>
		</main>
        <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>