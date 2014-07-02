<%@ include file="include/header.jsp" %>
 
    <div class="container">

      <div class="starter-template">
       <h1> 결과 : ${message}</h1> 
      
      <div class="panel panel-default"> 
		 
	  </div>
      
	<div class="btn-group">
	  <button type="button" id="btn_list" class="btn btn-default">목록</button> 
	</div>
		
	</form>
      </div>
      
    <script>
    $( document ).ready(function() {  
	    $("#btn_list").click(function() { 
	    	location.href="user?action=list";
	    });    
    });
    </script>

    </div><!-- /.container -->

<%@ include file="include/footer.jsp" %>