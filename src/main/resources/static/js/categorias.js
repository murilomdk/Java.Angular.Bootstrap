var app = angular.module('categorias', []);

app.controller('ctrl', function($scope, $http) {
	
	$scope.listar = function() {
		$http({
	        method : "GET",
	        url : "http://localhost:8085/projeto/categorias"
	    }).then((response) => {
	        $scope.categorias = response.data;
	    }, (response) => {
	        alert('erro GET');
	    });
	};
	
	$scope.salvar = function() {
		$http({
	        method : "POST",
	        url : "http://localhost:8085/projeto/categorias",
	        data: $scope.categoria
	    }).then((response) => {
	        $scope.listar();
	        $scope.novo();
	    }, (response) => {
	        alert('erro POST');
	    });
	}
	
	$scope.seleciona = (categoria) => {
		$scope.categoria = angular.copy(categoria);
	}
	
	$scope.novo = () => {
		$scope.categoria = {};
	}
	
	$scope.excluir = (categoria) => {
		if(confirm("Tem certeza????")) {
			$http({
		        method : "DELETE",
		        url : "http://localhost:8085/projeto/categorias/" + categoria.id 
		    }).then((response) => {
		        $scope.listar();
		        $scope.novo();
		    }, (response) => {
		        alert('erro DELETE');
		    });
		}
	}
	
	$scope.order = 'id';
	
	$scope.ordenar = (campo) => {
		$scope.order = campo;
	}
	
	$scope.listar();
	
});