'use strict';

angular.module('mediaCenter.series.controllers', [])
    .controller('SeriesController', function ($scope, series,BackgroundImageService) {
        BackgroundImageService.setDefault();
        $scope.selectedSeries = {};
        $scope.allSeries = series;

    })
    .controller('SeriesListController', function ($scope, NavigationService, $state) {
        this.navigation = function (parent, current) {
            return {
                up: function (p) {
                    var next = (current.navigationIndex - 1 <= 1) ? 1 : (current.navigationIndex - 1);
                    return {navigationIndex: next};
                },
                down: function (p) {
                    var next = (current.navigationIndex + 1 > parent.children().length) ? parent.children().length : (current.navigationIndex + 1);
                    return {navigationIndex: next};
                },
                in: function (p) {
                    $scope.select(angular.element('[data-navigation-group="seriesList"] :nth-child(' + current.navigationIndex + ')').data('name'));
                }
            };
        };
        NavigationService.registerNavigationGroup({
            default: {navigationIndex: 0},
            name: 'seriesList',
            navFn: this.navigation,
            onBack: function () {
                $state.go('home', null, {reload: true});
            }
        });
        NavigationService.setActiveGroup('seriesList');

        $scope.select = function (name) {
            $state.go("series.details", {name: name});
        }
    })
    .controller('SeriesDetailsController', function ($scope, BackgroundImageService, $stateParams, $filter, series) {
        var selected = $filter('filter')(series, $stateParams, true);
        if (selected.length == 1) {
            selected = selected[0];
            $scope.selectedSeries = selected;

            if ($scope.selectedSeries != undefined && $scope.selectedSeries.posterImages != undefined) {
                var size = $scope.selectedSeries.posterImages.length;
                $scope.poster = $scope.selectedSeries.posterImages[Math.floor(Math.random() * size)].webPath;
                size = $scope.selectedSeries.fanArtImages.length;
                BackgroundImageService.image = $scope.selectedSeries.fanArtImages[Math.floor(Math.random() * size)].webPath;
            }
        }

    })
    .controller('SeriesEpisodesController', function ($scope, $state, NavigationService) {
        this.navigation = function (parent, current) {
            console.log(parent);
            return {
                up: function (p) {
                    var next = (current.navigationIndex - 1 <= 1) ? 1 : (current.navigationIndex - 1);
                    return {navigationIndex: next};
                },
                down: function (p) {
                    var next = (current.navigationIndex + 1 > parent.children().length) ? parent.children().length : (current.navigationIndex + 1);
                    return {navigationIndex: next};
                },
                in: function (p) {
                    var $element = angular.element('[data-navigation-group="episodeList"] :nth-child(' + current.navigationIndex + ')');
                    $scope.select($element.data('navigation-id'), $element.data('season'));
                }
            };
        };
        NavigationService.registerNavigationGroup({
            default: {navigationIndex: 0},
            name: 'episodeList',
            navFn: this.navigation,
            onBack: function () {
                $state.go('series', {name: null}, {reload: true});
            }
        });
        NavigationService.setActiveGroup('episodeList');


        $scope.select = function (epNum, season) {
            $state.go('playback.series', {
                series: $scope.selectedSeries.id,
                season: season,
                episode: epNum
            });
        }
    });
