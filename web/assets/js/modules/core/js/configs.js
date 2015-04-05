'use strict';

angular.module('mediaCenter.core.configs', [])
    .config(function ($stateProvider, $urlRouterProvider, $provide, $httpProvider) {
        $urlRouterProvider.otherwise("/home");

        $stateProvider
            .state('home', {
                url: '/home',
                views: {
                    'main-view': {
                        controller: 'MainMenuController',
                        templateUrl: '/assets/js/modules/core/templates/mainMenu.html'
                    }
                }
            });

        $provide.factory('loadingHttpInterceptor', function($q,LoadingService) {
            return {
                // optional method
                'request': function(config) {
                    console.log("start_request");
                    LoadingService.start();
                    return config;
                },

                // optional method
                'requestError': function(rejection) {
                    console.log("stop_request");
                    LoadingService.stop();
                    return $q.reject(rejection);
                },



                // optional method
                'response': function(response) {
                    console.log("stop_request");
                    LoadingService.stop();
                    return response;
                },

                // optional method
                'responseError': function(rejection) {
                    console.log("stop_request");
                    LoadingService.stop();
                    return $q.reject(rejection);
                }
            };
        });

        $httpProvider.interceptors.push('loadingHttpInterceptor');
    });
