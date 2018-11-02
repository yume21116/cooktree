<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
         <h2>レシピ一覧</h2>

         <c:forEach var="reshipi" items="${reshipis}">
            <a href="${pageContext.request.contextPath}/show?id=${reshipi.id}">
               <c:out value="${reshipi.name}" />
            </a>
         </c:forEach>
     </c:param>
</c:import>







