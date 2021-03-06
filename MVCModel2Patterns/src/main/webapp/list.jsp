<%@ include file="include/header.jsp" %>


 
    <div class="container">

      <div class="starter-template">
        <h1>사용자 목록 </h1> 
      </div>
      
      <div>  
		
		
		<div class="btn-group">
		  <button type="button" id="btn_input" class="btn btn-default">등록</button>
		  <button type="button" id="btn_logout" class="btn btn-default">로그아웃</button>
	 	</div>
		
		<BR/><BR/>
		
		<div class="panel panel-default"> 
		  <div class="panel-heading"> 사용자 : ${sessionScope.id}</div>
		
		  <!-- Table -->
		  <table class="table">
		    	<thead>
				    <tr>
						<th>아이디</th>
						<th>이름</th>
						<th>권한</th> 
				    </tr>
				</thead>
				<tbody>
				<c:forEach items="${requestScope.userList}" var="user">				
					<tr>
						<td>${user.id}</td>
						<td><a href='user?action=view&id=${user.id}'>${user.name}</a></td>
						<td>${user.role}</td> 
					</tr> 
				</c:forEach>
				</tbody>
		  </table>
		</div>

      </div>

    </div><!-- /.container -->


	<script>
    $( document ).ready(function() { 
	    $("#btn_input").click(function() { 
	    	location.href="user?action=input";
	    });    

	    $("#btn_logout").click(function() { 
	    	location.href="user?action=logout";
	    });   
	       
    });
    </script>


<%@ include file="include/footer.jsp" %>

