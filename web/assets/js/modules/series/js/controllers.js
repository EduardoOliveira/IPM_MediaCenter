'use strict';

angular.module('mediaCenter.series.controllers', [])
    .controller('SeriesManagerController', function ($scope,SeriesListService,BackgroundImageService,$stateParams,SeriesService,$filter) {
        var series = SeriesService.series;
        console.log($stateParams);
        var selected = $filter('filter')(series,$stateParams,true);
        if(selected.length > 0){
            selected = selected[0];
            $scope.selected = selected;
            if($scope.selected.posterImages != undefined){
                var size = $scope.selected.posterImages.length;
                $scope.poster = $scope.selected.posterImages[Math.floor(Math.random() * size)].webPath;
                size = $scope.selected.fanArtImages.length;
                BackgroundImageService.image = $scope.selected.fanArtImages[Math.floor(Math.random() * size)].webPath;
            }
        }
    });
