'use strict';

angular.module('mediaCenter.movies.services', [])
    .service('MoviesService', function ($resource) {
        var movies = [
            {
                id: 1,
                name: 'Asad1',
                releaseDate: '1990/12/31',
                rate: 9,
                description: 'Long Boring ass text',
                cast: [],
                director: {}
            },
            {
                id: 2,
                name: 'Asad2',
                releaseDate: '1990/12/31',
                rate: 9,
                description: 'Long Boring ass text',
                cast: [],
                director: {}
            }

        ];
        this.selected = {};
        for (var i = 4; i < 100; i++) {
            movies.push({
                id: i,
                name: 'Asad' + i,
                releaseDate: '1990/12/31',
                rate: 9,
                description: 'Long Boring ass text',
                cast: [],
                director: {}
            })
        }

        this.getList = function () {
            return {
                name: 'movies-list',
                elements: movies,
                content: 'name',
                id: 'id'
            };
        };

        this.setSelected = function (movie) {
            this.selected = movie;
        };
    });