'use strict';

angular.module('mediaCenter.core.services', [])
    .service('NavigationService', function () {
        this.group = {};
        this.graphicalNavigation = new GraphicalNavigation();
        var that = this;

        this.setActiveGroup = function (group) {
            this.group = group;
            this.navigateTo({
                group: this.group.navigationGroup,
                id: this.group.default
            });
        };

        this.navigateTo = function (params) {
            console.log(params);
            this.graphicalNavigation.activate({
                group: params.group,
                id: params.id
            });
            this.group.focused = params.id;
        };

        this.goUp = function () {
            that.navigateTo({
                group: that.group.navigationGroup,
                id: that.group.navigationElements[that.group.focused].up({})
            });
        };

        this.goDown = function () {
            that.navigateTo({
                group: that.group.navigationGroup,
                id: that.group.navigationElements[that.group.focused].down({})
            });
        };

        this.goLeft = function () {
            that.navigateTo({
                group: that.group.navigationGroup,
                id: that.group.navigationElements[that.group.focused].left({})
            });

        };

        this.goRight = function () {
            that.navigateTo({
                group: that.group.navigationGroup,
                id: that.group.navigationElements[that.group.focused].right({})
            });
        };

    });
