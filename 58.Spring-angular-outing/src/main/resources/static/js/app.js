//modul ngRoute umozliwiajacy odwolywanie sie do uslug routingu
angular.module('app', ['ngRoute','ngResource'])
//$routeProvider - pozwala zdefiniowac szablon i powiazany z nim kontroler zaladowane po przejsciu do adresu URL
.config(function ($routeProvider) {
	//routeProvider przyjmuej dwa argumenty:
	//adres URL (tu '/list')
	//obiekt konfiguracji, zawierajacy adres do szablonu i kontroller
	$routeProvider
	.when('/list', {
		templateUrl: 'partials/list.html',
		controller: 'ListController',
		controllerAs: 'listCtrl'
	})
	.when('/details/:id', {
		templateUrl: 'partials/details.html',
		controller: 'DetailsController',
		controllerAs: 'detailsCtrl'
	})
	.when('/new', {
		templateUrl: 'partials/new.html',
		controller: 'NewController',
		controllerAs: 'newCtrl'
	})
	//tak jak w if-else, jezeli zadna inan metoda nie bedzie użyta, przyjmuje tylko adres do redirect
	.otherwise({
		redirectTo: '/list'
	});
})
//stala definiująca endpoint restowy
.constant('BOOK_ENDPOINT', '/api/books/:id')
//fabryka zwraca konstruktor umozliwiajacy komunikacje z baza danych
.factory('Book', function($resource, BOOK_ENDPOINT) {
	//zwraca TYLKO konstruktor z metodami query, get, etc NIE OBIEKT
	return $resource(BOOK_ENDPOINT);
})
//wykorzystuje konstruktor z uslugi factory
.service('Books', function(Book) {
	this.getAll = function() {
		//zwraca OBIEKTY wykorzystując KONSTRUKTOR z "Book"
		return Book.query();
	}
	this.get = function(index) {
		//zwraca OBIEKT wykorzystując KONSTRUKTOR z "Book"
		return Book.get({id: index});
	}
	//wywołuje metodę $save na obiekcie book wysylajaca zadanie POST do endpointu
	this.add = function(book) {
		book.$save();
	}
})
.controller('ListController', function(Books) {
	var vm = this;
	vm.books = Books.getAll();
})
//$routeParams pozwala odczytac parametr z adresu URL (w tym wypadku jest to :id zdefiniowane w konfiguracji 
//$routeProvider jako pierwszy argument
.controller('DetailsController', function($routeParams, Books) {
	var vm = this;
	var bookIndex = $routeParams.id;
	//na podstawie $routeParams.id pobieramy ksiazke uzywajac metody .get z uslugi service 'Books'
	vm.book = Books.get(bookIndex);
})

.controller('NewController', function(Books, Book) {
	var vm = this;
	//pole zbindowane z modelem book z formularza
	
	//do wlasnosci book jest dopisany nwoy obiekt wstrzyknięty przez kontroler Book
	//bez tego nie mozna wywolac $save w serwisie
	vm.book = new Book();
	
	vm.saveBook = function() {
		//ustala id ksiazki jako maksymalny rozmiar tablicy z książkami
		//jpa samo stworzy id ksiazki
		//vm.book.id = Books.size();
		
		//dodaje ksiazke do książek z argumentem przekazanym z formularza
		Books.add(vm.book);
		
		//czysci wlasnosc vm.book
		vm.book = new Book();
	}
});

