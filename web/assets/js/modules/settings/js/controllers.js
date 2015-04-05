'use strict';

angular.module('mediaCenter.settings.controllers', [])
    .controller('SettingsManagerController', function ($scope,SettingsListService,SettingsService) {
        $scope.$watch( function () { return SettingsListService.selected; }, function (data) {
            $scope.selected = SettingsListService.selected;
        }, true);

        $scope.save = function(group){
            var settings = new SettingsService(group);
            settings.$save();
        };
    });
