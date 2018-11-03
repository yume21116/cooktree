<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/app.jsp">
     <c:param name="content">
          <% request.setCharacterEncoding("UTF-8"); %>



          <h2><c:out value="${reshipi.name}" /></h2>
          <p>作り方<br />
          <c:out value="${reshipi.content}" /></p>
          <p>作成日時 :<fmt:formatDate value="${reshipi.created_at}" pattern="yyyy-MM-dd HH:mm:ss" /></p>

          <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p><br /><br />
          <p><a href="${pageContext.request.contextPath}/edit?id=${reshipi.id}">編集する</a></p>


     </c:param>
</c:import>

