'use strict';

angular.module('mediaCenter.series.services', [])
    .service('SeriesListService', function (SeriesService) {
        this.series = SeriesService.getSeries();
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
    .service('SeriesService', function (SeriesFactory) {
        var series = [];

        this.getSeries = function(){
            if( series.length == 0){
                series = SeriesFactory.query();
            }
            return series;
        }
    })
    .factory('SeriesFactory', function ($resource) {
        return $resource('/api/series/');
    });