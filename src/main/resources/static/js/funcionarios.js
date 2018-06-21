var app = angular.module('funcionarios', []);

app.controller('ctrl', function($scope, $http) {
	
	$scope.listar = function() {
		$http({
	        method : "GET",
	        url : "http://localhost:8085/projeto/funcionarios"
	    }).then((response) => {
	        $scope.funcionarios = response.data;
	    }, (response) => {
	        alert('erro GET');
	    });
	};
	
	$scope.salvar = function() {
		$http({
	        method : "POST",
	        url : "http://localhost:8085/projeto/funcionarios",
	        data: $scope.funcionario
	    }).then((response) => {
	        $scope.listar();
	        $scope.novo();
	    }, (response) => {
	        alert('erro POST');
	    });
	}
	
	$scope.seleciona = (funcionario) => {
		$scope.funcionario = angular.copy(funcionario);
	}
	
	$scope.novo = () => {
		$scope.funcionario = {};
	}
	
	$scope.excluir = (funcionario) => {
		if(confirm("Tem certeza????")) {
			$http({
		        method : "DELETE",
		        url : "http://localhost:8085/projeto/funcionarios/" + funcionario.id 
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