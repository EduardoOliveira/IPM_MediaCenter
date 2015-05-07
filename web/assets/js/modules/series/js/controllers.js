'use strict';

angular.module('mediaCenter.series.controllers', [])
    .controller('SeriesManagerController', function ($scope,SeriesListService,BackgroundImageService) {
        $scope.$watch( function () { return SeriesListService.selected; }, function (data) {
            $scope.selected = SeriesListService.selected;
            if($scope.selected.posterImages != undefined){
                var size = $scope.selected.posterImages.length;
                $scope.poster = $scope.selected.posterImages[Math.floor(Math.random() * size)].webPath;
                size = $scope.selected.fanArtImages.length;
                BackgroundImageService.image = $scope.selected.fanArtImages[Math.floor(Math.random() * size)].webPath;
            }
        }, true);
    });
