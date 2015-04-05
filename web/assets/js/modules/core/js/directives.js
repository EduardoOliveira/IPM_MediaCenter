'use strict';

angular.module('mediaCenter.core.directives', [])
    .directive('alphaScroll', function () {
        return {
            restrict: 'E'
        }
    })
    .directive('starRating', function () {
        return {
            restrict: 'E'
        }
    })
    .directive('loadingScreen', function () {
        return {
            controller: function ($scope,LoadingService) {
                $scope.$watch( function () { return LoadingService.loaders; }, function (data) {
                    $scope.show = LoadingService.loaders>0?"show":"";
                }, true);
            },
            restrict: 'E',
            templateUrl: '/assets/js/modules/core/templates/loadingScreen.html'
        }
    })
;

