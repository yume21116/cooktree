<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>CookTree</title>
    </head>
    <body>
          <div id="wrapper">
              <div id="header">
              </div>
                  <h1>CookTree</h1>
                  <p id="new"><a href="${pageContext.request.contextPath}/new">新規レシピの投稿</a></p>

              <div id="content">
                  ${param.content}
              </div>
              <div id="footer">

              </div>
          </div>
    </body>
</html>





