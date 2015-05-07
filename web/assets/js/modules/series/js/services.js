'use strict';

angular.module('mediaCenter.series.services', [])
    .service('SeriesListService', function (SeriesService) {
        this.series = SeriesService.query();
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
    .factory('SeriesService', function ($resource) {
        return $resource('/api/series/');
    });