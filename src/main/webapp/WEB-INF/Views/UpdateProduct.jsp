<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.6/angular.js"></script>


<script>
	var supplier = ${supList};
	
	var category = ${catList};
	var product = ${prodList};

	
		angular.module('myApp', []).controller('myCtrl', function($scope) {
			$scope.supp = supplier;
			$scope.cate = category;
			$scope.prod = product;
	});
</script>

<%@ include file="AdminHeader.jsp"%>
<br>
<br>
<br>
	<div class="container" ng-app="myApp">

		<div
			class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
			<div class="panel panel-default">

				<div class="panel-body">
					<form:form action="UpdateProduct" method="post" commandName="product">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input type="text" path="itemID"
										class="form-control input-sm floatlabel" placeholder="ID" readonly="true"
										 value="${proObject.itemID}"></form:input>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input type="text" path="itemName"
										class="form-control input-sm"  placeholder="name" 
										value="${proObject.itemName}"></form:input>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input type="text" path="qty"
										class="form-control input-sm floatlabel" placeholder="Quantity"
										 value="${proObject.qty}"></form:input>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input type="text" path="price"
										class="form-control input-sm"  placeholder="Price" 
										value="${proObject.price}"></form:input>
								</div>
							</div>
						</div>
						
							<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group" ng-controller="myCtrl">


										<form:select path="supplierId">
											<option value="-1">Select Supplier</option>

											<option ng-repeat="sup in supp" value="{{sup.supId}}">{{sup.supName}}</option>
										</form:select>

									</div>
								
								<div class="form-group" ng-controller="myCtrl">

										<form:select path="categoryId">
											<option value="-1">select Category</option>

											<option ng-repeat="cat in cate" value="{{cat.catId}}">{{cat.catName}}</option>
										</form:select>

									</div>
</div>
							</div>
						</div>
						
						<div class="row">
								<div class=form-group">


									<form:textarea path="description" value="${proObject.description}"
										class="form-control input-sm" placeholder="Description"></form:textarea>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="form-group">
									
									<form:input type="file" path="image"
										class="form-control input-sm" />
								
								</div>
							</div>
						

						<input type="submit" value="Update" class="btn btn-info btn-block">


					</form:form>

				</div>
			</div>
		</div>
		</div>
</body>
</html>