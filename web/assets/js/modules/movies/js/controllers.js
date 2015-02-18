'use strict';

angular.module('mediaCenter.movies.controllers', [])
    .controller('MovieListController', function ($scope) {
        var movies = [
            {
                name: 'Asad',
                releaseDate: '1990/12/31',
                rate: 9,
                description: 'Long Boring ass text',
                cast: [],
                director: {}
            },
            {
                name: 'Asad',
                releaseDate: '1990/12/31',
                rate: 9,
                description: 'Long Boring ass text',
                cast: [],
                director: {}
            },
            {
                name: 'Asad',
                releaseDate: '1990/12/31',
                rate: 9,
                description: 'Long Boring ass text',
                cast: [],
                director: {}
            }
        ];

        $scope.list = {
            elements: movies
        };

    }).controller('MovieDetailsController', function ($scope) {

    }).controller('MoviePlaybackController', function () {

    });
