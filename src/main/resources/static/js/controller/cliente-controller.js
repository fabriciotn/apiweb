/**
 * Controller de clientes
 */

appCliente.controller ("clienteController", function  ($scope, $http){
	
	$scope.clientes=[];
	$scope.cliente={}; //Bind com o form
	$scope.estados=[];
	
	carregarClientes= function (){
		token = localStorage.getItem("userToken");
		$http.defaults.headers.common.Authorization = 'Bearer '+ token;
		
		$http({method:'GET', url:'http://localhost:8080/admin/clientes'})
		.then(function (response){
			$scope.clientes=response.data;
			carregarEstados();
		} , function (response){
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	carregarEstados= function (){
		$http({method:'GET', url:'http://localhost:8080/estados'})
		.then(function (response){
			$scope.estados=response.data;
		} , function (response){
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarCliente= function (){
		if ($scope.frmCliente.$valid){
			$http({method:'POST', url:'http://localhost:8080/admin/clientes',data:$scope.cliente})
			.then(function (response){
				//$scope.clientes.push(response.data) ;
				carregarClientes();
				$scope.cancelarAlteracaoCliente();
				$scope.frmCliente.$setPristine(true);
			} , function (response){
				console.log(response.data);
				console.log(response.status);
			});
		}else {
			window.alert("Dados inválidos!");
		}
	}
	
	$scope.excluirCliente=function(cliente){
		$http({method:'DELETE', url:'http://localhost:8080/admin/clientes/'+cliente.id})
		.then(function (response){
			
			pos = $scope.clientes.indexOf(cliente);
			$scope.clientes.splice(pos , 1);
			
		} , function (response){
			console.log(response.data);
			console.log(response.status);
			
		});	
		
	};
	
	$scope.alterarCliente= function (cli){
		$scope.cliente = angular.copy(cli);
	};
	
	
	$scope.cancelarAlteracaoCliente=function (){
		$scope.cliente={};
	};
	
	carregarClientes();
});