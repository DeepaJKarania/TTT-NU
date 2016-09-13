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
<%@include file="Header.jsp" %>

	<div class="container">
<br>

<div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title"> sign up <small>It's free!</small></h3>
			 			</div>
			 			<div class="panel-body">
			    		<form:form  method="post" commandName="register">
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			                <form:input type="text"  path="first_name" class="form-control input-sm floatlabel" placeholder="First Name" required="true"></form:input>
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="text" name="last_name" path="last_name" class="form-control input-sm" placeholder="Last Name"></form:input>
			    					</div>
			    				</div>
			    			</div>

			    			<div class="form-group">
			    				<form:input type="email" name="email" path="email" class="form-control input-sm" placeholder="Email Address"></form:input>
			    			</div>

			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="password" name="password" path="password" class="form-control input-sm" placeholder="Password"></form:input>
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="password" name="password_confirmation" path="password_confirmation" class="form-control input-sm" placeholder="Confirm Password"></form:input>
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="text" name="phon" path="phone" class="form-control input-sm" placeholder="phone"></form:input>
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						
			    					<form:textarea path="address" name="address" class="form-control input-sm" placeholder="address"></form:textarea>
			    					</div>
			    				</div>
			    			</div>
			    			
			    			
			    			<input type="submit" value="Register" class="btn btn-info btn-block">
			    		
			    		</form:form>
			    	</div>
	    		</div>
    	
	
    </div>
    </div>

				
		<%@include file="Footer.jsp" %>
	
</body>
</html>