'use strict';

angular.module('mediaCenter.session.controllers', [])
    .controller('SessionManagerController', function ($scope, $rootScope, $resource, WebSocketService, localStorageService, SlaveDevice) {
        $scope.sessionName = "MainSession";
        $scope.uuid = null;
        $scope.slaves = [];
        $scope.latency = -20;

        localStorageService.set('sessionName', $scope.sessionName);
        localStorageService.set('uuid', $scope.uuid);

        WebSocketService.register('pt.iscte.ipm.mediacenter.core.events.ConnectSyncEvent', function (event) {
            $scope.uuid = event.uuid;
            localStorageService.set('uuid', event.uuid);
            $scope.$apply();
            $scope.getSlaves();
        });

        WebSocketService.register('pt.iscte.ipm.mediacenter.core.events.SlaveDeviceSyncEvent', function (event) {
            $scope.slaves = event.slaveDevices;
            console.log($scope.slaves);
            $scope.$apply();
        });

        $rootScope.$on("pong", function (event, data) {
            $scope.latency = data.latency;
            $scope.$apply();
        });

        $scope.getSlaves = function () {
            $scope.slaves = SlaveDevice.query({uuid: $scope.uuid});
        };

        $scope.removeSlave = function (uuid) {
            SlaveDevice.disconnect({uuid: $scope.uuid, slave: uuid});
        };
    });
