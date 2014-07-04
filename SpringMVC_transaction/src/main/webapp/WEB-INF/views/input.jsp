<%@ include file="include/header.jsp" %>
 
    <div class="container">

      <div class="starter-template">
        <h1>사용자 추가 : ${sessionScope.id}</h1> 
      
      
      <c:choose>
	      <c:when test="${updateid!=null}">
     		 <form name="theform" action="<c:url value="/"/>user/update.do" method="post">  
	      </c:when> 
	      <c:otherwise>
     		 <form name="theform" action="<c:url value="/"/>user/save.do" method="post">
	      </c:otherwise>
  	  </c:choose>
      <div class="panel panel-default"> 
		  <div class="panel-heading"> 사용자 : ${sessionScope.id}</div>
		 
			  <!-- Table -->
			  <table class="table">
				<tbody>
					<tr> 
			       		<td>아이디</td>	
			       		<td><input type="text" name="id" id="id" value="${requestScope.user.id}"/></td>
			       
			       	</tr>
					<tr> 
			       		<td>암호</td>
       					<td><input type="text" name="password" id="password" value="${requestScope.user.password}"/></td>
			       	</tr>
					<tr> 
			       		<td>이 름</td>	
			       		<td><input type="text" name="name" id="name" value="${requestScope.user.name}"/></td>
			       	</tr>
					<tr> 
			       		<td>역 할</td> 		
			       		<td><input type="text" name="role" id="role" value="${requestScope.user.role}"/></td>
			       	</tr>
				</tbody> 
			</table>
		</div>
      
	<div class="btn-group">
	  <button type="button" id="btn_submit" class="btn btn-default">등록</button>
	  <button type="button" id="btn_cancel" class="btn btn-default">취소</button> 
	</div>
		
	</form>
      </div>
      
    <script>
    $( document ).ready(function() { 
    	 $("#btn_submit").click(function() {
		    	if($("#id").val() == ""){
		    		alert("Input ID");
		    		$("#id").focus();
		    		return false;
		    	}else if($("#password").val() == ""){
		    		alert("Input Password");
		    		$("#password").focus();
		    		return false;
		    	}else if($("#name").val() == ""){
		    		alert("Input name");
		    		$("#name").focus();
		    		return false;
		    	}else if($("#role").val() == ""){
		    		alert("Input role");
		    		$("#role").focus();
		    		return false;
		    	}
		    	document.theform.submit();
	    });    
    	 
	    $("#btn_cancel").click(function() { 
	    	location.href="<c:url value="/"/>user/list.do";
	    });   
	     
    });
    </script>

    </div><!-- /.container -->

<%@ include file="include/footer.jsp" %>