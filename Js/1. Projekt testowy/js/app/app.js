//definicja modułu angulara o nazwie "app"

//var app = angular.module('app', []);
//definicja kontrolera
//app.controller('HelloController', function($scope) {
//    //obiekt $scope ktory zastąpi exampleVariable - posrednik miedzy html a JS
//    //jest to wiazanie dwukierunkowe, zmiana wartosci w exampleVariable wplynie od razu na 
//    //zmiane w kodzie html
//    $scope.exampleVariable = 'Ten tekst będzie wstawiony w miejsce podwójnych nawiasów    klamrowych';
//});

//ta sama funkcja poddana "zminifikacji" - usuniecie bialych znakow, zmianie dlugich nazw na pojedyncze znaki, etc.

//app.controller('HelloController', ['$scope', function($scope) {
//    $scope.exampleVariable = 'Ten tekst będzie wstawiony w miejsce podwójnych nawiasów klamrowych';
//}]);

//Inny sposob deklaracji kontrolera - przez konstruktor (czytelniejszy)
var app = angular.module('app', []);

app.controller('HelloController', function() {
    this.exampleVariable = 'Przykładowy tekst';
});

app.controller('ClickController', function() {
    this.header = "Header przed zmianami";
    this.changeHeader = function() {
        this.header = this.textInput;
    }
    this.headerClick = function() {
    this.header = this.header.toUpperCase();
}
});

//kontroler myszki
app.controller('MouseController', function() {
    this.mouseDown = function() {
        console.log('Mouse down');
    }
    this.mouseUp = function() {
        console.log('Mouse Up');
    }
    this.mouseEnter = function() {
        console.log('Mouse enter');
    }
    this.mouseLeave = function() {
        console.log('Mouse leave');
    }
    this.mouseMove = function() {
        console.log('Mouse move');
    }
    this.mouseOver = function() {
        console.log('Mouse over');
    }
});

//kontroler klawiszy
app.controller('KeyController', function() {
    this.up = 0;
    this.down = 0;
    this.press = 0;
    this.keyDown = function() {
        this.down++;
    }
    this.keyUp = function() {
        this.up++;
    }
    this.keyPress = function() {
        this.press++;
    }
});

//kontroler stanu
app.controller('ChangeController', function() {
    this.header = 'Odznaczony';
    this.changeState = function() {
        //jesli jest zaznaczony, checkbox zwraca "true" jesli nie jest zaznaczony zwraca "false"
        this.header = this.checkbox? 'Zaznaczony' : 'Odznaczony';
    }
});