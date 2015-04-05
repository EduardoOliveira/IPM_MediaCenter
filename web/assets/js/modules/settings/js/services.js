'use strict';

angular.module('mediaCenter.settings.services', [])
    .service('SettingsListService', function ($resource,SettingsService) {
        this.settings = SettingsService.query();
        this.selected = {};
        this.getList = function () {
            return {
                name: 'settings-list',
                elements: this.settings,
                content: 'label',
                id: 'id'
            };
        };

        this.setSelected = function (setting) {
            this.selected = setting;
        };
    })
    .factory('SettingsService', function ($resource) {
        return $resource('/api/settings/:group/:setting');
    });