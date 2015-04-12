'use strict';

angular.module('mediaCenter.music.configs', [])
    .config(function ($stateProvider) {
        $stateProvider
            .state('music', {
                url: '/music',
                resolve:{
                    ListService:function(ArtistsListService){
                        return ArtistsListService;
                    }
                },
                views: {
                    'main-view': {
                        templateUrl: '/assets/js/modules/core/templates/splitPane.html'
                    },
                    'leftPane@music': {
                        controller: 'ListController',
                        templateUrl: '/assets/js/modules/core/templates/listComponent.html'
                    },
                    'rightPane@music': {
                        controller: 'MusicManagerController',
                        templateUrl: 'assets/js/modules/music/templates/artistDetails.html'
                    }
                }
            });
    });
