'use strict';
angular.module('View1', ['ngRoute']).config(function ($routeProvider) {
    $routeProvider.when('/view1', {
        templateUrl: 'app/view1/view1',
        controller: 'view1Ctrl',
    }).when('/', {
        redirectTo: '/view1'
    }).otherwise({
        redirectTo: '/view1'
    });
});
