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
        <h1>사용자 상세 보기</h1>
        

       <table>
       	<tr>
       		<td>아이디</td>
       		<td>${requestScope.user.id}</td>
       	</tr>
       	<tr>
       		<td>암호</td>
       		<td><input type="text" name="password" id="password" value="${requestScope.user.id}"/></td>
       	</tr>
       	<tr>
       		<td>이 름</td>
       		<td>${requestScope.user.name}</td>
       	</tr>
       	<tr>
       		<td>역 할</td>
       		<td>${requestScope.user.role}</td>
       	</tr> 
       
       </table>
       
       <button>목록</button>
       <button>수정</button>
       <button>삭제</button>
      
      
      </div>

    </div><!-- /.container -->




<%@ include file="include/footer.jsp" %>