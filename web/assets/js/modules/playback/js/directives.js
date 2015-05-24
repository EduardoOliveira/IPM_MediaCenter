'use strict';

angular.module('mediaCenter.playback.directives', [])
    .directive('playbackControls', function () {
        return {
            controller: 'PlaybackController',
            restrict: 'E',
            templateUrl: '/assets/js/modules/playback/templates/playbackControls.html'
        }
    });

