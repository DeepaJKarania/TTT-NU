<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.6/angular.js"></script>

<%@ include file="AdminHeader.jsp"%>

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


<div class="container-fluid" ng-app="myApp">
<c:choose>

<c:when test="${checked}">
	<div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
		<div class="panel panel-default">

			<div class="panel-body">

				<form:form action="addProduct" method="post" commandName="product" enctype="multipart/form-data">
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								Product ID
								<form:input type="text" path="itemID"
									class="form-control input-sm floatlabel"
									placeholder="Product Id" />

							</div>

							<div class="form-group">
								Product Name
								<form:input type="text" path="itemName"
									class="form-control input-sm floatlabel"
									placeholder="Product Name" />

							</div>
						</div>

					</div>


					<div class="form-group">
						Product Quantity
						<form:input type="text" path="qty" class="form-control input-sm"
							placeholder="Quantity"></form:input>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6">
						<div class="form-group">
							Price
							<form:input type="text" path="price"
								class="form-control input-sm" placeholder="Price"></form:input>
						</div>



					</div>
					<div class="row">

						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group" ng-controller="myCtrl">


								<form:select path="supplierId">
									<option value="-1">Select Supplier</option>

									<option ng-repeat="sup in supp" value="{{sup.supId}}">{{sup.supName}}</option>
								</form:select>

							</div>



							<div class="row">
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


							<form:textarea path="description" name="description"
								class="form-control input-sm" placeholder="Description"></form:textarea>
						</div>
					</div>

					<div class="row">

						<div class="form-group">

							<form:input type="file" path="pimage"
								class="form-control input-sm" />

						</div>

					</div>



					<input type="submit" value="Add" class="btn btn-block">
					<input type="reset" value="Reset" class="btn btn-block">

				</form:form>

			</div>
		</div>
	</div>

</c:when>
<c:otherwise>


			<div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">

					<div class="panel-body">
						<form:form action="addProduct" method="post" commandName="product">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										Product ID
										<form:input type="text" path="itemID"
											class="form-control input-sm floatlabel"
											placeholder="Product Id" />

									</div>

									<div class="form-group">
										Product Name
										<form:input type="text" path="itemName"
											class="form-control input-sm floatlabel"
											placeholder="Product Name" />

									</div>
								</div>

							</div>


							<div class="form-group">
								Product Quantity
								<form:input type="text" path="qty" class="form-control input-sm"
									placeholder="Quantity"></form:input>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									Price
									<form:input type="text" path="price"
										class="form-control input-sm" placeholder="Price"></form:input>
								</div>



							</div>
							<div class="row">

								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group" ng-controller="myCtrl">


										<form:select path="supplierId">
											<option value="-1">Select Supplier</option>

											<option ng-repeat="sup in supp" value="{{sup.supId}}">{{sup.supName}}</option>
										</form:select>

									</div>
								</div>


								<div class="row">
									<div class="form-group" ng-controller="myCtrl">

										<form:select path="categoryId">
											<option value="-1">select Category</option>

											<option ng-repeat="cat in cate" value="{{cat.catId}}">{{cat.catName}}</option>
										</form:select>

									</div>


								</div>

							</div>



							<div class="row">

								<div class=form-group">


									<form:textarea path="description" name="description"
										class="form-control input-sm" placeholder="Description"></form:textarea>
								</div>


								<div class="form-group">

									<form:input type="file" path="pimage"
										class="form-control input-sm" />

								</div>

							</div>



							<input type="submit" value="Add" class="btn btn-info btn-block">
							<input type="reset" value="Reset" class="btn btn-info btn-block">

						</form:form>
					</div>
				</div>
			</div>

</c:otherwise>
</c:choose>
<div ng-controller="myCtrl">
					<div id="custom-search-input">
						<input type="text" class="search-query form-control"
							placeholder="Search" ng-model="searchText" />
					</div>



					<div class="row col-md-6 col-md-offset-2">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Product ID</th>
									<th>Product Name</th>
									<th>SupplierId</th>
									<th>CategoryId</th>
									<th>Description</th>
									<th>Quantity</th>
									<th>Image</th>
									<th class="">Action</th>
								</tr>
							</thead>
							<tr class="success" ng-repeat="pro in prod|filter:searchText">
								<td>{{pro.itemID}}</td>
								<td>{{pro.itemName}}</td>
								<td>{{pro.supplierId}}</td>
								<td>{{pro.categoryId}}</td>
								<td>{{pro.description}}</td>
								<td>{{pro.qty}}</td>
								<td><img src="./resources/img/{{pro.itemID}}.jpg" width="50" height="50"/></td>
								<td class="text-center"><a class='btn btn-info btn-xs'
									href="editProduct?pId={{pro.itemID}}">Edit</a> <a
									href="deleteProduct?pId={{pro.itemID}}"
									class="btn btn-danger btn-xs">Delete</a></td>
							</tr>
						</table>
					</div>
				</div>

			</div>


<%@include file="AdminFooter.jsp"%>
