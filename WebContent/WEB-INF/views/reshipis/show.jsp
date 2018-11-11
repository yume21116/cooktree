<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/app.jsp">
     <c:param name="content">
       <c:choose>
         <c:when test="${reshipi != null}">
          <% request.setCharacterEncoding("UTF-8"); %>


         <body>
          <h2 id="reshipiname"><c:out value="${reshipi.name}" /></h2><br />
         <div id="radius">
          <p>作り方<br />
          <c:out value="${reshipi.content}" /></p><br /><br />
          <p id="format">作成日時 :<fmt:formatDate value="${reshipi.created_at}" pattern="yyyy-MM-dd" /></p>
         </div>

         <p><c:out value="${picture.reshipi_id}" /></p>



         <div id="ran">
          <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p><br /><br />
         </div>
         <div id="ran2">
          <p><a href="${pageContext.request.contextPath}/edit?id=${reshipi.id}">編集する</a></p>
         </div>
         </c:when>
        <c:otherwise>
            <h2>お探しのデータは見つかりませんでした</h2>
        </c:otherwise>
       </c:choose>
      </body>
     </c:param>
</c:import>

