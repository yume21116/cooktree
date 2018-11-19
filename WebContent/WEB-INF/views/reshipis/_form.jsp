<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errors != null}">
  <div id ="flush_error">
       入力内容が足りません。  <br />
       <c:forEach var="error" items="${errors}">
       ・<c:out value="${error}" /><br />
       </c:forEach>
  </div>
 </c:if>
 <br />
<div id="form">

     <label for="name">名前</label><br />
     <input type="text" name="name" value="${reshipi.name}" />
     <br /><br />

     <label for="content">作り方</label><br />
     <input type="text" name="content" value="${reshipi.content}" />
     <br /><br />


     <input type="file" name="file_name"  value="${picture.reshipi_id}" /><br />

      <input type="hidden" name="reshipi_id" value="${picture.reshipi_id}" /><br />
     <input type="hidden" name="_token" value="${_token}" />
     <button type="submit">投稿</button>

</div>