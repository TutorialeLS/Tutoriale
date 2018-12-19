//odwolanie do modulu app
angular.module('app')
//tworzone uslugi w module 'app'
.value('appName', 'Java Book Store')
.constant('appVersion', '0.1')
.factory('Book', function() {
    return function Book(title, author, isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
})
.service('BookService', function(Book) {
    this.books = [
        new Book('Henryk Sienkiewicz', 'Krzyżacy', '123456789'),
        new Book('Adam Mickiewicz', 'Dziady', "1324354657"),
        new Book('Maria Konopnicka', 'Dym', "9786756453")
    ];
    this.saveBook = function(book) {
        this.books.push(book);
    }
});