<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
	<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
    <link rel="stylesheet" href="../../resources/css/noticeBoard.css">
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
                            <li><a href="/board/questionList.do" style="font-weight: bold;">상품문의</a></li>
                            <li><a href="./csDetail.html">FAQ</a></li>
                        </ul>
                    </div>
                    <div class="noticeBoard">
                        <table>
                            <tr>
                                <td>번호</td>
                                <td>제목</td>
                                <td>작성자</td>
                                <td>작성일</td>
                            </tr>
                            <c:forEach var="question" items="${requestScope.qList}">
                            <tr>
                                <td>${question.boardNo }</td>
                                <td>
                                	<a href="/detailBoard.do?boardNo=${boardNo }" >${question.boardSubject }</a>
                                </td>
                                <td>${question.boardWriter }</td>
                                <td>${question.boardWriteDate }</td>
                            </tr>
                            </c:forEach>
                            <tfoot>
                            	<tr align="center">
                            		<td colspan="3">
                            		<c:url var="pageUrl" value="/board/questionList.do">
                            			<c:param name="page" value="${pInfo.startNavi -1 }"></c:param>
                            		</c:url>
                            		<c:if test="${pInfo.startNavi != 1}">
                            			<a href="${pageUrl }">[이전]</a>
                            		</c:if>
                            		<c:forEach begin="${pInfo.startNavi }" end="${pInfo.endNavi }" var="p">
                            			<c:url var="pageUrl" value="/board/questionList.do">
                            				<c:param name="page" value="${p }"></c:param>
                            			</c:url>
                            			<a href="${pageUrl }">${p }</a>&nbsp;
                            		</c:forEach>
                            		<c:url var="nextUrl" value="/board/questionList.do">
                           				<c:param name="page" value="${pInfo.endNavi+1 }"></c:param>
                           			</c:url>
                           			<c:if test="${pInfo.naviTotalCount != pInfo.endNavi }">
                            			<a href="${nextUrl }">[다음]</a>
                            		</c:if>
                            		</td>
									<td>
										<a href="/board/insert.do">글쓰기</a>
									</td>
                            	</tr>
                            </tfoot>
                            <tr>
							</tr>
							
                        </table>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    </body>
</html>