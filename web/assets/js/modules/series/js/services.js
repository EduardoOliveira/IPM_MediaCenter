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
    .service('SeriesService',function(SeriesFactory){
        this.series = SeriesFactory.query();
    })
    .factory('SeriesFactory', function ($resource) {
        return $resource('/api/series/');
    });