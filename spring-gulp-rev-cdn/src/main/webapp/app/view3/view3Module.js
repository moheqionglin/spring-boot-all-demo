'use strict';
angular.module('View3', ['ngRoute']).config(function ($routeProvider) {
    $routeProvider.when('/view3', {
        templateUrl: 'app/view3/view3',
        controller: 'view3Ctrl',
    });
});
