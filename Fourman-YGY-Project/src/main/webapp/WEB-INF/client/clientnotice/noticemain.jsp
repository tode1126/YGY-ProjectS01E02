<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
  총 <b>${totalCount }</b> 개의 글이 있습니다.
</div>
<br><br>

  <div align="center"><b>공지 사항</b></div>
  
  <table align="center">
   
    <tr align="center">
    
       <th style="width: 100px;">번호</th>
       <th style="width: 100px;">제 목</th>
       <th style="width: 100px;">작성자</th>
       <th style="width: 100px;">조회</th>
       <th style="width: 100px;">작성일</th>
    </tr>
    
    <br>
    
    <c:forEach var ="ndto" items="${list }">
    
      <tr>
      
        <td>
          <input type="checkbox" num="${ndto.notice_pk }">${no }
          </td>
        <c:set var="no" value="${no-1 }"/>
          <td><a href="#?num=${ndto.notice_pk }&pageNum=${currentPage}">${ndto.subject }</a></td>
          <td>${ndto.notice_writer }</td>
          <td>${ndto.notice_readcount }</td>
          <td>
           <fmt:formatDate value="${ndto.notice_writeday }"
             pattern="yyyy-MM-dd"/>
          </td>
          
      </tr>
      
      </c:forEach>
  </table>
  
  <div align="right">
  <button type="button" id="btndel">선택한글 삭제</button>
  
  <button 
  onclick="location.href='noticeWriteForm.do'">글쓰기</button>
  </div>
</body>
</html>

