<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
          <div id="flush_success">
            <c:out value="${flush}"></c:out>
           </div>
        </c:if>
         <h2 id="reshipi">Reshipi a Table</h2><br />

         <c:forEach var="reshipi" items="${reshipis}">
            <a href="${pageContext.request.contextPath}/show?id=${reshipi.id}">
               <c:out value="${reshipi.name}" /><br />
            </a>
         </c:forEach>
     </c:param>
</c:import>