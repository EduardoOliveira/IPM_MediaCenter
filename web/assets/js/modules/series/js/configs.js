'use strict';

angular.module('mediaCenter.series.configs', [])
    .config(function ($stateProvider) {
        $stateProvider
            .state('series', {
                url: '/series',
                resolve: {
                    ListService: function (SeriesListService) {
                        return SeriesListService;
                    }
                },
                views: {
                    'main-view': {
                        templateUrl: '/assets/js/modules/core/templates/splitPane.html'
                    },
                    'leftPane@series': {
                        controller: 'ListController',
                        templateUrl: '/assets/js/modules/core/templates/listComponent.html'
                    }
                }
            })
            .state('series.selected', {
                url: '/:name',
                resolve: {
                    ListService: function (EpisodeListService) {
                        return EpisodeListService;
                    }
                },
                views: {
                    'rightPane@series': {
                        controller: 'SeriesManagerController',
                        templateUrl: 'assets/js/modules/series/templates/seriesDetails.html'
                    },
                    'episodesBlock@series.selected': {
                        controller: 'ListController',
                        templateUrl: '/assets/js/modules/core/templates/listComponent.html'
                    }
                }
            });
    });
