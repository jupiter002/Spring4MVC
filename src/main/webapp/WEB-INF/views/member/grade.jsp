<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main>
  <h2>성적조회</h2>
  <form name="gradefrm">
    <div><label for="id">아이디</label>
      <input type="text" name="id" id="id"></div> <!--  -->
    <div><label for="pw">비밀번호</label>
      <input type="password" name="pw" id="pw"></div>
      <div><label for="grade">등급</label>
        <input type="number" name="grade" id="grade"></div>

    <div><label></label>
      <button type="button" class="btn btn-primary" id="loginbtn">성적 조회</button>
    </div>
  </form>
</main>
<script src="/assets/js/member.js"></script>

