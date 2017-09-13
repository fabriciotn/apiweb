appCliente.factory("tokenInterceptor", function($q, $location){
	return {
		'request' : function(config){
			token = localStorage.getItem("userToken");
			config.headers.Authorization = 'Bearer '+ token;
			return config;
		}
	};
});