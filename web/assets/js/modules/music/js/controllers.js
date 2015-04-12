'use strict';

angular.module('mediaCenter.music.controllers', [])
    .controller('MusicManagerController', function ($scope,ArtistsListService) {
        $scope.$watch( function () { return ArtistsListService.selected; }, function (data) {
            $scope.selected = ArtistsListService.selected;
        }, true);
    });
