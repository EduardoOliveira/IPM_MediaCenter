'use strict';

angular.module('mediaCenter.series.configs', [])
    .config(function ($stateProvider) {
        $stateProvider
            .state('series', {
                url: '/series/:name?',
                resolve: {
                    ListService: function (SeriesListService) {
                        return SeriesListService;
                    },
                    detailpartial: function ($templateCache, $http) {
                        $http.get('/assets/js/modules/series/templates/seriesDetails.html', { cache: $templateCache });
                        $http.get('/assets/js/modules/series/templates/episodesList.html', { cache: $templateCache });
                    }
                },
                views: {
                    'main-view': {
                        controller:'SeriesController',
                        templateUrl: '/assets/js/modules/core/templates/splitPane.html'
                    },
                    'leftPane@series': {
                        controller: 'ListController',
                        templateUrl: '/assets/js/modules/core/templates/listComponent.html'
                    }
                }
            })
            .state('series.details', {
                url: '/details',
                views: {
                    'rightPane@series': {
                        controller: 'SeriesDetailsController',
                        templateUrl: '/assets/js/modules/series/templates/seriesDetails.html'
                    },
                    'episodesBlock@series.details': {
                        controller: 'SeriesEpisodesController',
                        templateUrl: '/assets/js/modules/series/templates/episodesList.html'
                    }
                }
            });
    });
