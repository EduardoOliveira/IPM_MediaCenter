'use strict';

angular.module('mediaCenter.series.services', [])
    .service('SeriesListService', function (SeriesService) {
        this.series = SeriesService.series;
        this.selected = {};
        this.getList = function () {
            return {
                name: 'series-list',
                elements: this.series,
                content: 'name',
                id: 'name'
            };
        };

        this.setSelected = function (series) {
            this.selected = series;
        };
    })
    .service('EpisodeListService', function () {
        this.getList = function () {
            return {
                name: 'episodes-list',
                elements: [
                    {
                        number: 0,
                        episodes: [
                            {
                                name: "bla",
                                epNum: 1
                            },
                            {
                                name: "bla2",
                                epNum: 2
                            }
                        ]
                    }, {
                        number: 1,
                        episodes: [
                            {
                                name: "bla",
                                epNum: 1
                            },
                            {
                                name: "bla2",
                                epNum: 2
                            }
                        ]
                    }
                ],
                content: 'number',
                id: 'number',
                sub: {
                    prop:'episodes',
                    content: 'name',
                    id: 'epNum'
                }
            };
        };
    })
    .service('SeriesService', function (SeriesFactory) {
        this.series = SeriesFactory.query();
    })
    .factory('SeriesFactory', function ($resource) {
        return $resource('/api/series/');
    });