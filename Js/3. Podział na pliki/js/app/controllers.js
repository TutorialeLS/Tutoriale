angular.module('app')
.controller('BookController', function (Book, BookService, appName, appVersion) {
    this.appName = appName;
    this.version = appVersion;
    this.books = BookService.books;
    this.addBook = function(book) {
        BookService.saveBook(new Book(book.title, book.author, book.isbn));
    }
});