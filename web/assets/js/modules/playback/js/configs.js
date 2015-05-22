'use strict';

angular.module('mediaCenter.playback.configs', [])
    .config(function ($stateProvider) {

        $stateProvider
            .state('playback', {
/*                views: {
                    'playback-layer': {
                        controller: 'MainMenuController',
                        templateUrl: '/assets/js/modules/core/templates/mainMenu.html'
                    }
                }*/
            })
            .state('playback.series', {
                url: '/playback/:series/:season/:episode',
                /*views: {
                    'playback-layer': {
                        controller: 'VideoPlaybackController',
                        templateUrl: '/assets/js/modules/playback/templates/videoPlayer.html'
                    }
                }*/
            });
    });
