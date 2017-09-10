/**
 * 
 */

appCliente.controller("estadoController", function ($scope, $http){

	$scope.estado={}; //Bind com o form
	$scope.estados=[];
	
	carregarEstados= function (){
		$http({method:'GET', url:'http://localhost:8080/estados'})
		.then(function (response){
			$scope.estados=response.data;
		} , function (response){
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarEstado= function (){
		if ($scope.frmEstado.$valid){
			$http({method:'POST', url:'http://localhost:8080/estados',data:$scope.estado})
			.then(function (response){
				//$scope.estados.push(response.data) ;
				carregarEstados();
				$scope.cancelarAlteracaoEstado();
				$scope.frmEstado.$setPristine(true);
			} , function (response){
				console.log(response.data);
				console.log(response.status);
			});
		}else {
			window.alert("Dados inválidos!");
		}
	}
	
	$scope.excluirEstado=function(estado){
		$http({method:'DELETE', url:'http://localhost:8080/estados/'+estado.id})
		.then(function (response){
			
			pos = $scope.estados.indexOf(estado);
			$scope.estados.splice(pos , 1);
			
		} , function (response){
			console.log(response.data);
			console.log(response.status);
			
		});	
		
	};
	
	$scope.alterarEstado= function (cli){
		$scope.estado = angular.copy(cli);
	};
	
	
	$scope.cancelarAlteracaoEstado=function (){
		$scope.estado={};
	};
	
	carregarEstados();
});