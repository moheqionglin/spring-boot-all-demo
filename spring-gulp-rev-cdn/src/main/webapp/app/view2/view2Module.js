'use strict';
angular.module('View2', ['ngRoute']).config(function ($routeProvider) {
    $routeProvider.when('/view2', {
        templateUrl: 'app/view2/view2',
        controller: 'view2Ctrl',
    });
});
