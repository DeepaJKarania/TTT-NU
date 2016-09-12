<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.6/angular.js"></script>

	<script>
		var cat = ${catList};
		angular.module('repeatSample', []).controller('repeatController',
				function($scope) {
					$scope.category = cat;

					$scope.sort = function(keyname) {
						$scope.sortKey = keyname; //set the sortKey to the param passed
						$scope.reverse = !$scope.reverse; //if true make it false and vice versa
					}

				});
	</script>

</head>


<body>
	<%@ include file="AdminHeader.jsp"%>
<div class=" container">

	<div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
		<div class="panel panel-default">

			<div class="panel-body">
				<form:form action="addCategory" method="post" commandName="category">
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<form:input type="text" path="catId"
									class="form-control input-sm floatlabel"
									placeholder="Category ID" required="true"></form:input>
							</div>
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<form:input type="text" path="catName"
									class="form-control input-sm" placeholder="Category Name"></form:input>
							</div>
						</div>
					</div>

					<div class="form-group">
						<form:input type="text" path="catDescription"
							class="form-control input-sm" placeholder="Description"></form:input>
					</div>

					<input type="submit" value="Add" class="btn btn-info btn-block">
					<br>
					<input type="reset" value="Reset" class="btn btn-info btn-block">

				</form:form>

			</div>
		</div>
	</div>

	<br>
	<br>

	<div ng-app="repeatSample" ng-controller="repeatController">
		<div id="custom-search-input">
			<input type="text" class="  search-query form-control"
				placeholder="Search" ng-model="searchText" />
		</div>

		<div class="row col-md-6 col-md-offset-2 custyle">
			<table class="table table-striped custab">
				<thead>
					<tr>
						<th>Category ID</th>
						<th>Category Name</th>
						<th>Description</th>
						<th class="text-center">Action</th>
					</tr>
				</thead>
				<tr class="success" ng-repeat="cate in category|filter:searchText">
					<td>{{cate.catId}}</td>
					<td>{{cate.catName}}</td>
					<td>{{cate.catDescription}}</td>
					<td class="text-center"><a class='btn btn-info btn-xs'
						href="editCategory?catId={{cate.catId}}"><span class="glyphicon glyphicon-edit"></span>Edit</a> 
						<a href="DeleteCategory?catId={{cate.catId}}" class="btn btn-danger btn-xs"><span
						class="glyphicon glyphicon-remove"></span>Del
							
				</a></td>
				</tr>
			</table>
		</div>
		</div>

</div>
<%@include file="AdminFooter.jsp"%>
</body>
</html>