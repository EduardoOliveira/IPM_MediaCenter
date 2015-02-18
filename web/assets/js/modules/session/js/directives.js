'use strict';

angular.module('mediaCenter.session.directives', [])
    .directive('sessionWidget', function () {
        return {
            controller:'SessionManagerController',
            restrict: 'E',
            templateUrl: '/assets/js/modules/session/templates/sessionsWidget.html'
        }
    });

