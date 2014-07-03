<%@ include file="include/header.jsp" %>
 
    <div class="container">

      <div class="starter-template">
       <h1> Result </h1> 
        
     	<div class="alert alert-info" role="alert">${message}</div>
	      
		<div class="btn-group">
		  <button type="button" id="btn_list" class="btn btn-default">목록</button> 
		</div>
		 
      </div>
      
    <script>
    $( document ).ready(function() {  
	    $("#btn_list").click(function() { 
	    	location.href="<c:url value="/"/>user/list.do";
	    });    
    });
    </script>

    </div><!-- /.container -->

<%@ include file="include/footer.jsp" %>