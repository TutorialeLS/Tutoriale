var app = angular.module('app', []);
//nazwa kontrolera
app.controller('HelloController', function($scope) {
    $scope.exampleVariable = 'Ten tekst będzie wstawiony w miejsce podwójnych nawiasów klamrowych';
});