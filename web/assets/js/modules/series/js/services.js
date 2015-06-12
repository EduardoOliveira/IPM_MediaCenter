'use strict';

angular.module('mediaCenter.series.services', [])
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