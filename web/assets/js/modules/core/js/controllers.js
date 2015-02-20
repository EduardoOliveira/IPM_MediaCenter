'use strict';

angular.module('mediaCenter.core.controllers', [])
    .controller('NavigationController', function ($scope, hotkeys,NavigationService) {
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

        $scope.$on('nav.up', NavigationService.goUp);
        $scope.$on('nav.down', NavigationService.goDown);
        $scope.$on('nav.left', NavigationService.goLeft);
        $scope.$on('nav.right', NavigationService.goRight);
    })

    .controller('MainMenuController', function ($scope, NavigationService) {
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

    });
