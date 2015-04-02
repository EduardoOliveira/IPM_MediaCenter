'use strict';

angular.module('mediaCenter.session.services', [])
    .factory('SlaveDevice', function ($resource) {
        return $resource('/api/devices/:uuid/slaves', {uuid: '@uuid'},
            {
                'disconnect': {
                    method: 'GET',
                    url: '/api/devices/:uuid/slaves/disconnect/:slave',
                    params: {uuid: '@uuid', slave: '@slave'}
                }
            });
    });