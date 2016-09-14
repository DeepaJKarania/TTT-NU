<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.6/angular.js"></script>

	<script>
		var sup = ${supList};
		angular.module('repeatSample', []).controller('repeatController',
				function($scope) {
					$scope.supplier = sup;

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
<br>
<center><h4 class="text-success">Manage Supplier</h4></center><br>
	<div
		class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
		<div class="panel panel-default">

			<div class="panel-body">
				<form:form action="addSupplier" method="post" commandName="supplier">
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<form:input type="text" path="supId"
									class="form-control input-sm floatlabel"
									placeholder="Supplier ID" readonly="true"></form:input>
							</div>
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<form:input type="text" path="supName"
									class="form-control input-sm" placeholder="Supplier Name"></form:input>
							</div>
						</div>
					</div>

					<div class="form-group">
						<form:input type="text" path="supAddress"
							class="form-control input-sm" placeholder="Address"></form:input>
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
			<table class="table table-striped table-border">
				<thead>
					<tr>
						<th>Supplier ID</th>
						<th>Supplier Name</th>
						<th>Supplier Address</th>
						<th class="text-center">Action</th>
					</tr>
				</thead>
				<tr class="success" ng-repeat="supr in supplier|filter:searchText">
					<td>{{supr.supId}}</td>
					<td>{{supr.supName}}</td>
					<td>{{supr.supAddress}}</td>
					<td class="text-center"><a class='btn btn-info btn-xs'
						href="editSupplier?supId={{supr.supId}}"><span class="glyphicon glyphicon-edit"></span>Edit</a> 
						</td><td><a href="DeleteSupplier?supId={{supr.supId}}" class="btn btn-danger btn-xs"><span
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