var app = angular.module('veiculos', []);

app.controller('ctrl', function($scope, $http) {
	
	$scope.listar = function() {
		$http({
	        method : "GET",
	        url : "http://localhost:8085/projeto/veiculos"
	    }).then((response) => {
	        $scope.veiculos = response.data;
	    }, (response) => {
	        alert('erro GET');
	    });
	};
	
	$scope.salvar = function() {
		$http({
	        method : "POST",
	        url : "http://localhost:8085/projeto/veiculos",
	        data: $scope.veiculo
	    }).then((response) => {
	        $scope.listar();
	        $scope.novo();
	    }, (response) => {
	        alert('erro POST');
	    });
	}
	
	$scope.seleciona = (veiculo) => {
		$scope.veiculo = angular.copy(veiculo);
	}
	
	$scope.novo = () => {
		$scope.veiculo = {};
	}
	
	$scope.excluir = (veiculo) => {
		if(confirm("Tem certeza????")) {
			$http({
		        method : "DELETE",
		        url : "http://localhost:8085/projeto/veiculos/" + veiculo.id 
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