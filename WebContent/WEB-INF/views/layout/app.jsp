<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>CookTree</title>

         <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
         <link rel="stylesheet" href="<c:url value='/css/style.css' />">

    </head>
    <body>
          <div id="wrapper">
             <div id="header">
              <div id="header_menu">
                  <span id="test1"><a href="<c:url value='/index' />">CookTree</a></span>
                  <span id="test2"><a href="${pageContext.request.contextPath}/new">New Reshipi</a></span>
              </div>
           </div>

              <div id="content">
                  ${param.content}
              </div>
              <div id="footer">
                   by Yuki Ito.
              </div>
           </div>

    </body>
</html>





