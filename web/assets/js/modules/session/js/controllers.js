'use strict';

angular.module('mediaCenter.session.controllers', [])
    .controller('SessionManagerController', function ($scope, $rootScope, $resource, WebSocketService,
                                                      localStorageService, SlaveDevice, NavigationService) {
        $scope.sessionName = "MainSession";
        $scope.uuid = null;
        $scope.slaves = [
            {
                name: "eqweqwe",
                uuid: "qweqwewqe",
                masterAddress: "wqeqweqweqwe"
            },
            {
                name: "eq2ddqwe",
                uuid: "qweqwd22ewqe",
                masterAddress: "wqeqw2we"
            },
            {
                name: "sa",
                uuid: "dsad",
                masterAddress: "wqeqe"
            },
            {
                name: "sa",
                uuid: "dsad",
                masterAddress: "wqeqe"
            },
            {
                name: "sa",
                uuid: "dsad",
                masterAddress: "wqeqe"
            },
            {
                name: "sa",
                uuid: "dsad",
                masterAddress: "wqeqe"
            },
            {
                name: "sa",
                uuid: "dsad",
                masterAddress: "wqeqe"
            },
            {
                name: "sa",
                uuid: "dsad",
                masterAddress: "wqeqe"
            },
            {
                name: "eq2ddqwe",
                uuid: "qweqwd22ewqe",
                masterAddress: "wqeqw2we"
            }
        ];
        $scope.latency = -20;
        var graphicalNavigation = new GraphicalNavigation();
        var $devicesList = $('session-widget').children('.devices').eq(0);
        this.navigation = function (current) {
            return {
                up: function (p) {
                    if (current - 1 < 0) return 0;
                    return current - 1
                },
                down: function (p) {
                    if (current + 1 > $scope.slaves.length - 1)
                        return $scope.slaves.length - 1;
                    return current + 1
                },
                in: function (p) {
                    $scope.removeSlave($scope.slaves[current].uuid)
                }
            };
        };
        NavigationService.registerNavigationGroup({
            default: 0,
            name: 'devices',
            navFn: this.navigation,
            onEnter: function(){
                $scope.open();
            },
            onExit: function(){
                $scope.close();
            }
        });

        localStorageService.set('sessionName', $scope.sessionName);
        localStorageService.set('uuid', $scope.uuid);

        WebSocketService.register('pt.iscte.ipm.mediacenter.core.events.ConnectSyncEvent', function (event) {
            $scope.uuid = event.uuid;
            localStorageService.set('uuid', event.uuid);
            $scope.$apply();
            $scope.getSlaves();
        });

        WebSocketService.register('pt.iscte.ipm.mediacenter.core.events.SlaveDeviceSyncEvent', function (event) {
            //$scope.slaves = event.slaveDevices;
            console.log($scope.slaves);
            $scope.$apply();
        });

        $rootScope.$on("pong", function (event, data) {
            $scope.latency = data.latency;
            $scope.$apply();
        });

        $scope.getSlaves = function () {
            //$scope.slaves = SlaveDevice.query({uuid: $scope.uuid});
        };

        $scope.open=function(){
            graphicalNavigation.open($devicesList);
        };

        $scope.close=function(){
            graphicalNavigation.close($devicesList);
        };

        $scope.openDevices = function(){
            NavigationService.setActiveGroup('devices');
        };

        $scope.removeSlave = function (uuid) {
            SlaveDevice.disconnect({uuid: $scope.uuid, slave: uuid});
        };
    });
