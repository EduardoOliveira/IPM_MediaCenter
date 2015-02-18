'use strict';

angular.module('mediaCenter.core.controllers', [])
    .controller('NavigationController', function ($scope) {

    }).controller('MainMenuController',function(){
        var mainMenuGui = new MainMenuGui({$element:$('.main-menu')});
    });
