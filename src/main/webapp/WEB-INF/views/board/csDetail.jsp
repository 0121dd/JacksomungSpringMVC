<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
	<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
    <link rel="stylesheet" href="../../resources/css/csDetail.css">
    <body>
        <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <jsp:include page="/WEB-INF/views/include/nav.jsp"></jsp:include>
        <main>
            <div class="divArea">
                <div class="noticDiv">
                    <h2>고객센터</h2>
                    <div class="nbList"> 
                        <ul>
                            <li><a href="/notice/list.do">공지사항</a></li>
                            <li><a href="/board/questionList.do"">상품문의</a></li>
                            <li><a href="#">FAQ</a></li>
                        </ul>
                    </div>
                    <div class="csDetailDiv">
                        <table>
                            <tr>
                                <td>제목</td>
                                <td>${qBoard.boardSubject }</td>
                            </tr>
                            <tr>
                                <td>작성자</td>
                                <td>${qBoard.boardWriter }</td>
                            </tr>
                            <tr>
                                <td>작성일</td>
                                <td>${qBoard.boardWriteDate }</td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                	<span>
                                    ${qBoard.boardContent }
                                	</span>
                                </td>
                            </tr>
                        </table>
                        <button id="backBtn">목록</button>
                    </div>
                </div>
            </div>
        </main>
        <footer>
            <div class="left_footer">
                <ul>
                    <li>
                        <div class="mini_img"></div>
                    </li>
                    <li>
                        <div class="footer_info">
                            company : 주식회사 작고 소중한 털뭉치 
                            owner : 김아름 <br>
                            address : 서울특별시 중구 남대문로 120 그레이츠 청계(구 대일빌딩) 2F, 3F <br>
                            business license : 123-45-67890 <br>
                            online business license : 제2023-서울강북-1234호 <br>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="right_footer">
                BANK INFO <br>
                신한 : 012-345-123456 <br>
                국민 : 12345-67-654321 <br>
                예금주 : (주) 작고 소중한 털뭉치
            </div>
        </footer>
    </body>
</html>