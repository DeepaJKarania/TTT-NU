angular.element(document).ready(function(){

    angular.module('myApp',[])
        .controller('myCtrl', ['$scope','store',function ($scope,store) {
            $scope.search = '';
            $scope.products = [];
            $scope.categories = [];
            
            $scope.categories = store.getCategories();
            $scope.products = store.getProducts();
            
            $scope.filterProductsByCategory = function(category){
                $scope.search = category;
            };
        }])
        // fake service, substitute with your server call ($http)
        .factory('store',function(){
            var categories = ['male','female'];
            var products = [
                {id: '1213',category: 'female'},
                {id: '2434',category: 'female'},
                {id: '2342',category: 'female'},
                {id: '5655',category: 'male'},
                {id: '6556',category: 'male'},
                {id: '6534',category: 'male'},
                {id: '7653',category: 'male'},
                {id: '2424',category: 'male'},
                {id: '6756',category: 'male'},
            ];
            return {
                getCategories : function(){
                    return categories;
                },
                getProducts : function(){
                    return products;
                }
            };
        });
    
    angular.bootstrap(document,['myApp']);
});