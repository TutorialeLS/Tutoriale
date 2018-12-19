angular.module('app', [])
.controller('ProductController', function($http) {
	//zdefiniowanie dodatkowej zmiennej, używanej zamiast "this"
	var vm = this;
	console.log(this);
	//pobiera dane z serwera
	function refreshData() {
		//wywołując usługę $http trzeba jej przekazac method i url endpointu
		//w wyniku wywolania otrzymujemy obiekt promise
		$http.get('api/products')
		//na obiekcie promise wywolujemy metodę .then przekazując dwie funkcje jako argumenty
		//succes - wywolywana kiedy wszystko bedzie ok
		//error - kiedy wyjdzie blad
		//wywolywane asynchronicznie, w wypadku gdy serwer potrzebuje wiecej czasu wyrzuci je po pewnym czasie
		//nazwy moga byc zmienione
		.then(function success(response) {
			//zwrocona wartosc
			vm.products = response.data;
			//wyswietlenie w konsoli wartosci
			console.log(vm.products);
		}, function error(response) {
			console.log('API error ' + response.status);
		});
		//reponse jest argumentem callbackow, przechowuje informacji o odpowiedzi z serwera
		//data – {string|Object} - treść odpowiedzi serwera,
		//status – {number} – kod HTTP odpowiedzi,
		//headers – {function([headerName])} – nagłówki odpowiedzi,
		//config – {Object} – obiekt konfiguracji, który wykorzystaliśmy do wysłania żądania,
		//statusText – {string} – kod odpowiedzi w postaci stringa.
	}
	//wysyla produkt do endpointu
	vm.addProduct = function(product) {
		//dodatkowo okreslona wlasnosc umozliwiajaca przekazanie "product" do endpointu
		$http.post('api/products', product)
		.then(function success(response) {
			//jesli wynik ok - odswiezamy widok
			refreshData();
			//czyscimy formularz
			vm.product = {};
		}, function error(response) {
			console.log('Data not saved ' + product);
		});
	}

	vm.appName = 'Product Manager';
	refreshData();
});