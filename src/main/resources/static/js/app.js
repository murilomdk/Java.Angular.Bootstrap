'use strict';

(function() {

	var app = angular.module('myApp', [ 'ui.router', 'myApp.controllers' ]);

	app.config(function($stateProvider, $urlRouterProvider) {

		$urlRouterProvider.otherwise('/home0');

		$stateProvider

		.state('home', {
			url : '/home',
			templateUrl : 'partial-home.html',
			controller : "UserRetrieveController"
		})

		.state('about', {
			url : '/about',
			templateUrl : 'partial-about.html',
			controller : "BeerRetrieveController"
		})

		.state('pessoas', {
			url : '/pessoas',
			templateUrl : 'partial-pessoas.html',
			controller : "PessoaController"
		})

		.state('multas', {
			url : '/multas',
			templateUrl : 'partial-multas.html',
			controller : "MultaController"
		})

		.state('avarias', {
			url : '/avarias',
			templateUrl : 'partial-avarias.html',
			controller : "AvariaController"
		})
		
		.state('veiculos', {
			url : '/veiculos',
			templateUrl : 'partial-veiculos.html',
			controller : "VeiculoController"
		});

	});
	
	app.service('myDataShared', function () {
       
	  var item = 'casa21';

        return {
            getItem: function () {
                return item;
            },
            setItem: function(value) {
                item = value;
            }
        };
    });

})();
