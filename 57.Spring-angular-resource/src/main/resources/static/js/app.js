//wstrzykiwanei modulu angular-resource do modulu app
angular.module('app', ['ngResource'])
// usluga $resource opakowuje usluge $http i dostarcza dodatkowe rzowiazania do
// komunikacji przez REST
// w wyniku wywolania uslugi $resource otrzymamy konstruktory z metodami ktore
// pozwola wykonac podstawowe
// zapytanai do endpointu

//po co tu jest usluga $http, dziala bez tego? nie uzywamy zadnej metody z $http skoro $resource ją opakowuje?
.controller('ProductController', function($http,$resource) {
	var vm = this;
	// na koncu sciezki jest zmienny parametr, odpytywanie po dowoln ych
	// parametrach umozliwia $resource
	var Product = $resource('api/products/:productId');
	// konstruktor uzyskany z usługi $resource
	// tworzony jest obiekt zbindowany z polami w formularzu
	// oraz ze wzgledfu na to, ze zostal stworzony przez konstruktor, zasób
	// reperezentujący Product,
	// posaida metody save, $get, $query, $remove i $delete ODZIEDZICZONE z
	// Product
	//TO JEST DODANIE WLASNOSCI product DO MODELU vm
	vm.product = new Product();

	function refreshData() {
		//tworzy zadanie GET do serwera korzystajac z metody .query z Product
		//DODANIE WLASNOSCI products DO MODELU vm
		vm.products = Product.query(
				function success(data, headers) {
					console.log('Pobrano dane: ' +  data);
					console.log(headers('Content-Type'));
				},
				function error(reponse) {
					console.log(response.status); //np. 404
				});
	}

//DODAJE WLASNOSC addProduct DO MODELU vm
	vm.addProduct = function(product) {
		console.log(vm.product.__proto__);
		//implementacja wzorca Active Record - podobnie jak w Javie dzialanie na obiektach w stanie zarzadzanym
		//wywolanie metody $save na samym obiekcie z formularza
		//"$" bo metoda należy do usługi $resource?
		vm.product.$save(function(data) {
			// po poprawnym zapisie odswieza i tworzy nowy obiekt modelu
			refreshData();
			vm.product = new Product();
		});
	}
	//korzysta z metody .get uslugi $resource do pobrania pojedynczego rekordu
	vm.loadData = function(id) {
		vm.details = Product.get({productId: id});
	}
	
	vm.appName = 'Product Manager';
	refreshData();
});
