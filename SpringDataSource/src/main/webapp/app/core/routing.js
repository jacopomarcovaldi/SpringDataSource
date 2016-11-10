
angular.module('dpApp').config(['$routeProvider',function($routeProvider) {
    $routeProvider
    .when("/", {
        template : "<mm-movies-list />"
    })
    .when("/home", {
        templateUrl : "<mm-movies-list />"
    })
    .otherwise({redirectTo : '/404'});
}]);

