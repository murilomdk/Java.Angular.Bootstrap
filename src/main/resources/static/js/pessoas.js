var app = angular.module('pessoas', []);

app.controller('ctrl', function($scope, $http) {
	
	$scope.listar = function() {
		$http({
	        method : "GET",
	        url : "http://localhost:8084/app01/pessoas"
	    }).then((response) => {
	        $scope.pessoas = response.data;
	    }, (response) => {
	        alert('erro GET');
	    });
	};
	
	$scope.salvar = function() {
		$http({
	        method : "POST",
	        url : "http://localhost:8084/app01/pessoas",
	        data: $scope.pessoa
	    }).then((response) => {
	        $scope.listar();
	        $scope.novo();
	    }, (response) => {
	        alert('erro POST');
	    });
	}
	
	$scope.seleciona = (pessoa) => {
		$scope.pessoa = angular.copy(pessoa);
	}
	
	$scope.novo = () => {
		$scope.pessoa = {};
	}
	
	$scope.excluir = (pessoa) => {
		if(confirm("Tem certeza????")) {
			$http({
		        method : "DELETE",
		        url : "http://localhost:8084/app01/pessoas/" + pessoa.id 
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