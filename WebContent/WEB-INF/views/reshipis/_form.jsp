<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="form">

     <label for="name">名前</label><br />
     <input type="text" name="name" value="${reshipi.name}" />
     <br /><br />

     <label for="content">作り方</label><br />
     <input type="text" name="content" value="${reshipi.content}" />
     <br /><br />


     <input type="file" name="file_name"  value="${picture.reshipi_id}" />



     <input type="hidden" name="_token" value="${_token}" />
     <button type="submit">投稿</button>

</div>