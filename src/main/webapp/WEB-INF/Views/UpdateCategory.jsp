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
	<%@include file="AdminHeader.jsp"%>

	<div class=" container">

		<div
			class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
			<div class="panel panel-default">

				<div class="panel-body">
					<form:form action="UpdateCategory" method="post" commandName="category">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input type="text" path="catId"
										class="form-control input-sm floatlabel"
										 value="${catObject.catId}"></form:input>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input type="text" path="catName"
										class="form-control input-sm"  value="${catObject.catName}"></form:input>
								</div>
							</div>
						</div>

						<div class="form-group">
							<form:input type="text" path="catDescription"
								class="form-control input-sm" value="${catObject.catDescription}"></form:input>
						</div>

						<input type="submit" value="Update" class="btn btn-info btn-block">


					</form:form>

				</div>
			</div>
		</div>
		</div>
</body>
</html>