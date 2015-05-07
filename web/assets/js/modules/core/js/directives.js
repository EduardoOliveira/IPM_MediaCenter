'use strict';

angular.module('mediaCenter.core.directives', [])
    .directive('loadingScreen', function () {
        return {
            controller: function ($scope, LoadingService) {
                $scope.$watch(function () {
                    return LoadingService.loaders;
                }, function (data) {
                    $scope.show = LoadingService.loaders > 0 ? "show" : "";
                }, true);
            },
            restrict: 'E',
            templateUrl: '/assets/js/modules/core/templates/loadingScreen.html'
        }
    })
    .directive('bgImage', function (BackgroundImageService) {
        return {
            link: function (scope, element, attrs) {
                scope.$watch(function () { return BackgroundImageService.image; },
                    function (data) {
                        element.css({
                            'background-image': 'url(' + BackgroundImageService.image + ')',
                            'background-size': 'cover',
                            'background-repeat': 'no-repeat',
                            'background-position': 'center center',
                            'background-attachment': 'fixed'
                        });
                    });
            }
        };
    });

