<%@ include file="include/header.jsp" %>

<body>

	
        <div class="row"><BR/><BR/><BR/><BR/><BR/><BR/></div>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" name="theform" id="theform" action="user?action=login" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Id" id="id" name="id" type="id" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" id="password" name="password" type="password" value="">
                                </div> 
                                
                                
                                <div class="checkbox">
                                    <label> 
                                    	${message}
                                    </label>
                                </div>
                                
                                <!-- Change this to a button or input when using this as a form -->
                                <button id="btn_submit" class="btn btn-lg btn-success btn-block">Login</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
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
		    	}
	    });    
    });
    </script>

<%@ include file="include/footer.jsp" %>
