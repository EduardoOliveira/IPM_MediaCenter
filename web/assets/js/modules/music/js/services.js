'use strict';

angular.module('mediaCenter.music.services', [])
    .service('ArtistsListService', function (ArtistsService) {
        this.artists = ArtistsService.query();
        this.selected = {};
        this.getList = function () {
            return {
                name: 'artists-list',
                elements: this.artists,
                content: 'name',
                id: 'name'
            };
        };

        this.setSelected = function (artist) {
            this.selected = artist;
        };
    })
    .factory('ArtistsService', function ($resource) {
        return $resource('/api/artists/');
    });