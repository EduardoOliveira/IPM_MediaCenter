'use strict';

angular.module('mediaCenter.core.directives', [])
    .directive('listComponent', function () {
        return {
            controller:'ListController',
            restrict: 'E',
            templateUrl: '/assets/js/modules/core/templates/listComponent.html'
        }
    });

