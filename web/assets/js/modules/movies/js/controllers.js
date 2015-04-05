'use strict';

angular.module('mediaCenter.movies.controllers', [])
    .controller('MovieDetailsController', function ($scope,MoviesService) {
        $scope.$watch( function () { return MoviesService.selected; }, function (data) {
            $scope.selected = MoviesService.selected;
        }, true);
    }).controller('MoviePlaybackController', function () {

    });
