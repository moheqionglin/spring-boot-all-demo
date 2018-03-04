angular.module('AppAll').controller('AppAll.AppCtrl', function($scope){

    $scope.currentUrl = 'view1';

    $scope.switchView = function(url){
        $scope.currentUrl = url;
    }

});