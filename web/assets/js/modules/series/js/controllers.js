'use strict';

angular.module('mediaCenter.series.controllers', [])
    .controller('SeriesController', function ($rootScope, $scope, SeriesService, $stateParams, $filter, $state) {
        var that = this;
        $scope.selectedSeries = {};
        $scope.series = [];


        this.updateSeries = function (series) {
            $scope.series = series;
            that.checkForSelection();
        };

        this.checkForSelection = function () {
            var selected = $filter('filter')($scope.series, $stateParams, true);
            if (selected.length == 1) {
                selected = selected[0];
                $scope.selectedSeries = selected;
                $state.go("series.details",$scope.selectedSeries);
            }
        };

        var series = SeriesService.getSeries();
        if (series.$resolved) {
            that.updateSeries(series);
        } else {
            series.$promise.then(function (data) {
                that.updateSeries(data);
            });
        }
    })
    .controller('SeriesDetailsController', function ($scope, BackgroundImageService) {
        $scope.$watch('selectedSeries', function () {
            console.log($scope.selectedSeries);
            if ($scope.selectedSeries != undefined && $scope.selectedSeries.posterImages != undefined) {
                var size = $scope.selectedSeries.posterImages.length;
                $scope.poster = $scope.selectedSeries.posterImages[Math.floor(Math.random() * size)].webPath;
                size = $scope.selectedSeries.fanArtImages.length;
                BackgroundImageService.image = $scope.selectedSeries.fanArtImages[Math.floor(Math.random() * size)].webPath;
            }
        });
    })
    .controller('SeriesEpisodesController', function ($scope) {

    });
