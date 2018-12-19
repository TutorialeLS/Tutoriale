
var app = angular.module('app', []);

app.controller('HrefController', function() {

    this.movies = [
        'b-Cr0EWwaTk',
        'zg79C7XM1Xs'
    ];
    this.imgSrc = 'http://javastart.pl/theme/genesis/pix/javastart.png';
    
      this.changeH1Style = function() {
        this.h1style = {'color': 'red'};
    }
    this.even = 'parzyste';
    this.odd = 'nieparzyste';
});


//test dzialania przycisku
function registerEvents() {
    var button = document.getElementById("button");
    //mozna dopisac tylko jedna funkcje do przycisku
    button.onclick = function() {
        console.log("wcislo");
    }
}
registerEvents();

//wytlumaczenie w html
//app2.controller('ShowHideController',function(){
//            
//                });


//dwa razy powtorzony styl, bo repeat controller nie zawieral kolorków dla HrefControllera - nie mozna bylo pobrac wlasnosci ctrl.even i ctrl.odd
app.controller('RepeatController', function() {
    function Person(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    this.people = [
        new Person('Jan', 'Kowalski'),
        new Person('Ania', 'Abacka'),
        new Person('Wojtek', 'Nowak')
    ];
      this.changeH1Style = function() {
        this.h1style = {'color': 'red'};
    }
    this.even = 'parzyste';
    this.odd = 'nieparzyste';
});


