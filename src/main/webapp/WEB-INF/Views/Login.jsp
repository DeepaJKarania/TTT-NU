<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="Header.jsp"%>


<div class="container">


<div class="row vertical-offset-100">
    	<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<center><h3 class="panel-title">Please sign in</h3></center>
			 	</div>
			  	<div class="panel-body">
			    	<form:form  method="post" commandName="login">
                    <fieldset>
			    	  	<div class="form-group">
			    		 <form:input type="email"  path="email" class="form-control input-sm floatlabel" placeholder="Email" required="true"></form:input>
			    		</div>
			    		<div class="form-group">
			    			 <form:input type="password"  path="password" class="form-control input-sm floatlabel" placeholder="Password" required="true"></form:input>
			    		</div>
			    	
			    		<input class="btn btn-sm btn-info btn-block" type="submit" value="Login">
			    	</fieldset>
			      	</form:form>
			      	<br>
			      
			    <a href=""></a><input class="btn btn-sm btn-info btn-block" type="button" value="Forget Password"></a>
			      	
			    </div>
			</div>
		</div>
	</div>

</div>

<%@include file="Footer.jsp" %>
</body>
</html>