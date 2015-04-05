'use strict';

angular.module('mediaCenter.settings.configs', [])
    .config(function ($stateProvider) {
        $stateProvider
            .state('settings', {
                url: '/settings',
                resolve:{
                    ListService:function(SettingsListService){
                        return SettingsListService;
                    }
                },
                views: {
                    'main-view': {
                        templateUrl: '/assets/js/modules/core/templates/splitPane.html'
                    },
                    'leftPane@settings': {
                        controller: 'ListController',
                        templateUrl: '/assets/js/modules/core/templates/listComponent.html'
                    },
                    'rightPane@settings': {
                        controller: 'SettingsManagerController',
                        templateUrl: 'assets/js/modules/settings/templates/settingsDetails.html'
                    }
                }
            });
    });
