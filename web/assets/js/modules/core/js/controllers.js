'use strict';

angular.module('mediaCenter.core.controllers', [])
    .controller('ListController', function ($scope, $window, ListService, NavigationService,$state) {
        this.navigation = function(current){
            return {
                up: function (p) {
                    var next =(current - 1 < 0)?0:(current - 1);
                    return next;
                },
                down: function (p) {
                    var next = (current + 1 > $scope.list.elements.length - 1)?$scope.list.elements.length - 1:(current + 1);
                    return next;
                },
                in: function (p) {
                    $scope.select(current)
                }
            };
        };
        $scope.list = ListService.getList();
        $scope.selected = {};
        NavigationService.registerNavigationGroup({
            default: 0,
            name: $scope.list.name,
            navFn: this.navigation
        });
        NavigationService.setActiveGroup($scope.list.name);
        $scope.isSelected = function (element) {
            return ($scope.selected[$scope.list.id] == element[$scope.list.id] ? "selected" : "");
        };
        $scope.select = function (i) {
            $scope.selected = $scope.list.elements[i];
            //NavigationService.navigateTo(i);
            //ListService.setSelected($scope.selected);
            $state.go("series", $scope.selected,{reload:true});
        };
    })
    .controller('NavigationController', function ($scope, hotkeys, NavigationService, WebSocketService) {
        hotkeys.add({
            combo: 'up',
            description: 'Go Up!',
            callback: NavigationService.goUp
        });
        hotkeys.add({
            combo: 'down',
            description: 'Go Down!',
            callback: NavigationService.goDown
        });
        hotkeys.add({
            combo: 'left',
            description: 'Go left!',
            callback: NavigationService.goLeft
        });
        hotkeys.add({
            combo: 'right',
            description: 'Go Right!',
            callback: NavigationService.goRight
        });
        hotkeys.add({
            combo: 'enter',
            description: 'Go In!',
            callback: NavigationService.goIn
        });
        hotkeys.add({
            combo: 'd',
            description: 'Devices!',
            callback: NavigationService.goDevices
        });
        hotkeys.add({
            combo: 'b',
            description: 'Go back!',
            callback: NavigationService.goBack
        });

        WebSocketService.register("pt.iscte.ipm.mediacenter.events.remote.NavigationSyncEvent", function (event) {
            console.log(event);
            switch (event.eventCode) {
                case "up":
                    NavigationService.goUp();
                    break;
                case "down":
                    NavigationService.goDown();
                    break;
                case "left":
                    NavigationService.goLeft();
                    break;
                case "right":
                    NavigationService.goRight();
                    break;
                case "ok":
                    NavigationService.goIn();
                    break;
                case "back":
                    NavigationService.goBack();
                    break;
                case "devices":
                    NavigationService.goDevices();
                    break;
            }
        });
    })
    .controller('MainMenuController', function ($scope, NavigationService,BackgroundImageService, $state) {
        var mainMenuGui = new MainMenuGui({$element: $('.main-menu')});
        this.navigation = function (parent,current) {
            var opts = {
                movies: {
                    left: function (params) {
                        return {navigationId: 'settings'}
                    },
                    right: function (params) {
                        return {navigationId: 'series'}
                    },
                    in: function (params) {
                        $scope.go('movies');
                    }
                },
                series: {
                    left: function (params) {
                        return {navigationId: 'movies'}
                    },
                    right: function (params) {
                        return {navigationId: 'music'}
                    },
                    in: function (params) {
                        $scope.go('series');
                    }
                },
                music: {
                    left: function (params) {
                        return {navigationId: 'series'}
                    },
                    right: function (params) {
                        return {navigationId: 'settings'}
                    },
                    in: function (params) {
                        $scope.go('music');
                    }
                },
                settings: {
                    left: function (params) {
                        return {navigationId: 'music'}
                    },
                    right: function (params) {
                        return {navigationId: 'movies'}
                    },
                    in: function (params) {
                        $scope.go('settings');
                    }
                }
            };
            return opts[current.navigationId];
        };


        NavigationService.registerNavigationGroup({
            default: {navigationId: 'movies'},
            name: 'main-menu',
            navFn: this.navigation
        });
        NavigationService.setActiveGroup('main-menu');

        $scope.go = function (nextView) {
            $state.go(nextView);
        };
    });
