
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.6/angular.js"></script>
<script>
	var prod = $
	{
		proList
	};
	angular.module('repeatSample', []).controller('repeatController',
			function($scope) {
				$scope.products = prod;

				$scope.sort = function(keyname) {
					$scope.sortKey = keyname; //set the sortKey to the param passed
					$scope.reverse = !$scope.reverse; //if true make it false and vice versa
				}

			});
</script>
<%@include file="Header.jsp"%>
<div class="container">

	<div ng-app="repeatSample" ng-controller="repeatController">
		<div id="custom-search-input">
			<input type="text" class="  search-query form-control"
				placeholder="Search" ng-model="searchText" />
		</div>
		<div id="products" class="row list-group" class="success"
			ng-repeat="product in products|filter:searchText">
			<div class="item  col-xs-4 col-lg-4">
				<div class="thumbnail">
					<a href="./resources/img/{{product.image}}.jpg"> <img
						class="group list-group-image"
						src="./resources/img/{{product.image}}.jpg" height="200"
						width="200" /></a>
					<div class="caption">
						<h4 class="group inner list-group-item-heading">
							{{product.itemName}}</h4>
						<p class="group inner list-group-item-text">
							{{product.discription}}
						<div class="row">
							<div class="col-xs-12 col-md-6">
								<p class="lead">{{product.price}}</p>
							</div>
							<div class="col-xs-12 col-md-6">
								<p class="lead">{{product.qty}}</p>
							</div>
							<div class="col-xs-12 col-md-6">
								<a class="btn btn-success" href="http://www.jquery2dotnet.com">Add
									to cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!--  

                <td><a href="ProductDescription?pid={{product.itemID}}">{{product.itemID}}</a></td>
                <td>{{product.itemName}}</td>
                <td>{{product.discription}}</td>
                <td>{{product.price}}</td>
                 <td>{{product.qty}}</td>
                
                <td><img src="/resources/{{product.pid}}.jpg" height="50px" width="50px"/></td>
            
</tr>
</table>
-->
		</div>
	</div>



	<!-- Display List data  but now in project we are using json withAnjular JS 
<div class="container">
      <div ng-controller="myCtrl">
    Free Form Search: <input type="text" ng-model="search" placeholder="Search" />
    <div>

<table border="2" width="70%" cellpadding="2">  
<tr><th>Product Id</th><th> Product Name</th><th>Description</th><th>Price</th><th>Quantity</th></tr>  
   <c:forEach var="obj" items="${list}">   
   <tr>  
   <td>${obj.itemID}</td>  
   <td>${obj.itemName}</td>  
   <td>${obj.discription}</td>  
   <td>${obj.price}</td>
   <td>${obj.qty}</td> 
    
     
   </c:forEach>  
   </table>  
  

      </div>
-->





</div>

</body>
</html>