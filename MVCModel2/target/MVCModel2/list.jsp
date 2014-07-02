<%@ include file="include/header.jsp" %>



    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">

      <div class="starter-template">
        <h1>사용자 목록</h1>
        
		<table>
         		<tr>
         			<th>아이디</th>
         			<th>이름</th>
         			<th>권한</th>
         		</tr>
         		
         		<c:forEach items="${requestScrope.userList}" var="user">
         		<tr>		
         			<td>${user.id}</td>
         			<td><a href='user?action=view&id=${user.id}'>${user.name}</a></td>
         			<td>${user.role}</td>                			                			
         		</tr>
         		</c:forEach>
         	              			
         		
         	</table>

      </div>

    </div><!-- /.container -->




<%@ include file="include/footer.jsp" %>