<%@ include file="include/header.jsp" %>




    <div class="container">

      <div class="starter-template">
        <h1>사용자 상세 보기 : ${sessionScope.id}</h1> 
      
      
      <div class="panel panel-default"> 
		  <div class="panel-heading"> 사용자 : ${sessionScope.id}</div>
		
			
			  <!-- Table -->
			  <table class="table">
				<tbody>
					<tr> 
			       		<td>아이디</td>
			       		<td>${requestScope.user.id}</td>
			       	</tr>
					<tr> 
			       		<td>암호</td>
       					<td><input type="password" name="password" id="password" value="${requestScope.user.password}"/></td>
			       	</tr>
					<tr> 
			       		<td>이 름</td>
			       		<td>${requestScope.user.name}</td>
			       	</tr>
					<tr> 
			       		<td>역 할</td>
			       		<td>${requestScope.user.role}</td>
			       	</tr>
				</tbody> 
			</table>
		</div>
      
	<div class="btn-group">
	  <button type="button" id="btn_list" class="btn btn-default">목록</button>
	  <button type="button" id="btn_edit" class="btn btn-default">수정</button>
	  <button type="button" id="btn_delete" class="btn btn-default">삭제</button>
	</div>

      </div>
      
    <script>
    $( document ).ready(function() { 
	    $("#btn_list").click(function() { 
	    	location.href="<c:url value="/"/>user/list.do";
	    });    

	    $("#btn_edit").click(function() { 
	    	location.href="<c:url value="/"/>user/input.do?id=${requestScope.user.id}";
	    });   
	    
	    $("#btn_delete").click(function() { 
	    	if(confirm("정말 삭제하시겠습니까?")){
	    		location.href="<c:url value="/"/>user/delete.do?id=${requestScope.user.id}";
	    	}
	    });     
    });
    </script>

    </div><!-- /.container -->




<%@ include file="include/footer.jsp" %>