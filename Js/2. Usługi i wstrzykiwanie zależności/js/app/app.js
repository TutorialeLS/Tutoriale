var app = angular.module('app', []);

//zła implementacja, konstruktor i metoda jest wewnatrz kontrollera 
//app.controller('BookController', function() {
//    function Book(title, author, isbn) {
//        this.title = title;
//        this.author = author;
//        this.isbn = isbn;
//    }
//    this.books = [
//        new Book('Henryk Sienkiewicz', 'Krzyżacy', '123456789'),
//        new Book('Adam Mickiewicz', 'Dziady', "1324354657"),
//        new Book('Maria Konopnicka', 'Dym', "9786756453")
//    ];
//    this.addBook = function(book) {
//        //dodaje obiekt book do listy books (na koncu listy) ze wskazanymi atrybutami
//        this.books.push(new Book(book.title, book.author, book.isbn));
//    }
//});
//----------------------------------------------------------------------------------------------------------------------
//dobra implementacja, kosntruktor i funkcje sa rozbite
//usluga factory zwraca w wyniku konstruktor wstrzyknięty do kontrollera
//app.factory('Book', function() {
//    function Book(title, author, isbn) {
//        this.title = title;
//        this.author = author;
//        this.isbn = isbn;
//    }
//    return Book;
//});
////wstrzykniecie konstruktora do kontrolera przez nazwę, bez podawania nazwy w cudzyslowiu
//app.controller('BookController', function (Book) {
//    this.books = [
//        new Book('Henryk Sienkiewicz', 'Krzyżacy', '123456789'),
//        new Book('Adam Mickiewicz', 'Dziady', "1324354657"),
//        new Book('Maria Konopnicka', 'Dym', "9786756453")
//    ];
//    this.addBook = function(book) {
//        this.books.push(new Book(book.title, book.author, book.isbn));
//    }
//});
//--------------------------------------------------------------------------------------------------------------------------------------

//LUB

//usluga service zwraca obiekt z metodą create ktora ma za zadanie stworzenie obiektu
//app.service('Book', function() {
//    function Book(title, author, isbn) {
//        this.title = title;
//        this.author = author;
//        this.isbn = isbn;
//    }
//    this.create = function(title, author, isbn) {
//        return new Book(title, author, isbn);
//    }
//});
////wstrzykniecie uslugi do kontrolera
//app.controller('BookController', function (Book) {
//    console.log(Book);
//    this.books = [
//        Book.create('Henryk Sienkiewicz', 'Krzyżacy', '123456789'),
//        Book.create('Adam Mickiewicz', 'Dziady', "1324354657"),
//        Book.create('Maria Konopnicka', 'Dym', "9786756453")
//    ];
//    this.addBook = function(book) {
//        this.books.push(new Book(book.title, book.author, book.isbn));
//    }
//});

////angular wywoła funkcję HelloFactory i zapamięta jej wynik
//app.factory('helloFactory', function HelloFactory() {
//    return {
//        hello: 'Jakiś tekst'
//    }
//});
//
////angular wywoła new HelloService() i zapamięta tak utworzony obiekt
//app.service('helloService', function HelloService() {
//    this.hello = 'Jakis tekst';
//});

//----------------------------------------------------------------------------------------------------------------------------------------------
//LUB uzycie factory i service - > pzowala na usuniecie informacji w jaki sposob sa tworzone obiekty w kontrolerze
//uslugi do pzrechowywania prostych wartosci, np. wspolnych dla calej aplikacji np. nazwa, wersja, adresy URI restowych endpointow
//zmienna
app.value('appName', "'Java Book Store'");
//stala
app.constant('appVersion', '0.1');
//tworzy konstruktor Book
app.factory('Book', function() {
    return function Book(title, author, isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
});
//wstrzykuje konstruktor Book, odpytujemy baze danych o wskazane obiekty, dodajemy metode saveBook i zwraca obiekt ktory umozliwia zapisywanie book w books
app.service('bookService', function(Book) {
    this.books = [
        new Book('Henryk Sienkiewicz', 'Krzyżacy', '123456789'),
        new Book('Adam Mickiewicz', 'Dziady', "1324354657"),
        new Book('Maria Konopnicka', 'Dym', "9786756453")
    ];
    this.saveBook = function(book) {
        this.books.push(book);
    }
});
//
app.controller('BookController', function (Book, bookService, appName, appVersion) {
    //books jest nadpisane przez books powstale w bookService
    this.books = bookService.books;
    this.version = appVersion;
    this.appName = appName;
    //metoda addBook jest metodą bookService.saveBook z konstruktorem z uslugi factory Book
    this.addBook = function(book) {
        bookService.saveBook(new Book(book.title, book.author, book.isbn));
    }
});


