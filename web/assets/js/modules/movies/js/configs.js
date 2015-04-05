'use strict';

angular.module('mediaCenter.movies.configs', [])
    .config(function ($stateProvider) {

        $stateProvider
            .state('movies', {
                url: '/movies',
                resolve:{
                    ListService:function(MoviesService){
                        return MoviesService;
                    }
                },
                views: {
                    'main-view': {
                        templateUrl: '/assets/js/modules/core/templates/splitPane.html'
                    },
                    'leftPane@movies': {
                        controller: 'ListController',
                        templateUrl: '/assets/js/modules/core/templates/listComponent.html'
                    },
                    'rightPane@movies': {
                        controller: 'MovieDetailsController',
                        templateUrl: '/assets/js/modules/core/templates/mediaDetails.html'
                    }
                }
            });
    });
