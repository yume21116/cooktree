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
         <br />

         <div id="pagination">
          (全 ${reshipis_count} 件)<br />
          <c:forEach var="i" begin="1" end="${((reshipis_count - 1) / 5) +1}" step="1">
             <c:choose>
                 <c:when test="${i == page}">
                      <c:out value="${i}" />&nbsp;
                 </c:when>
                 <c:otherwise>
                     <a href="${pageContext.request.contextPath}/index?page=${i}"><c:out value="${i}" /></a>&nbsp;
                 </c:otherwise>
             </c:choose>
          </c:forEach>

         </div>
     </c:param>
</c:import>