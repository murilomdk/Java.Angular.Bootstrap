var app = angular.module('avarias', []);

app.controller('ctrl', function($scope, $http) {
	
	$scope.listar = function() {
		$http({
	        method : "GET",
	        url : "http://localhost:8085/projeto/avarias"
	    }).then((response) => {
	        $scope.avarias = response.data;
	    }, (response) => {
	        alert('erro GET');
	    });
	};
	
	$scope.salvar = function() {
		$http({
	        method : "POST",
	        url : "http://localhost:8085/projeto/avarias",
	        data: $scope.avaria
	    }).then((response) => {
	        $scope.listar();
	        $scope.novo();
	    }, (response) => {
	        alert('erro POST');
	    });
	}
	
	$scope.seleciona = (avaria) => {
		$scope.avaria = angular.copy(avaria);
	}
	
	$scope.novo = () => {
		$scope.avaria = {};
	}
	
	$scope.excluir = (avaria) => {
		if(confirm("Tem certeza????")) {
			$http({
		        method : "DELETE",
		        url : "http://localhost:8085/projeto/avarias/" + avaria.id 
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