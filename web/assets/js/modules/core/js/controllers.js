'use strict';

angular.module('mediaCenter.core.controllers', [])
    .controller('NavigationController', function ($scope, hotkeys, NavigationService,WebSocketService,$rootScope) {
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

        $rootScope.$on("pt.iscte.ipm.mediacenter.events.remote.NavigationEvent",function(data){
            console.log(data);
            switch (data.keyCode){
                case "up": NavigationService.goUp();
                    break;
                case "down": NavigationService.goDown();
                    break;
                case "left": NavigationService.goLeft();
                    break;
                case "right": NavigationService.goRight();
                    break;
                case "ok": NavigationService.goIn();
                    break;
            }
        });
    })

    .controller('MainMenuController', function ($scope, NavigationService,$state) {
        var mainMenuGui = new MainMenuGui({$element: $('.main-menu')});
        var navigation = {
            movies: {
                left: function (params) {
                    return 'settings'
                },
                right: function (params) {
                    return 'series'
                }
            },
            series: {
                left: function (params) {
                    return 'movies'
                },
                right: function (params) {
                    return 'music'
                }
            },
            music: {
                left: function (params) {
                    return 'series'
                },
                right: function (params) {
                    return 'settings'
                }
            },
            settings: {
                left: function (params) {
                    return 'music'
                },
                right: function (params) {
                    return 'movies'
                }
            }
        };

        NavigationService.setActiveGroup({
            default: 'movies',
            navigationGroup: 'main-menu',
            navigationElements: navigation
        });

        $scope.go = function(nextView){
            $state.go(nextView);
        };

    });
