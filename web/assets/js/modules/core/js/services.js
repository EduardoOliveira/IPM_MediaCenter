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
            this.graphicalNavigation.focus({
                group: params.group,
                id: params.id
            });
            this.group.focused = params.id;
        };

        this.goUp = function () {
            var element = that.group.navigationElements[that.group.focused];
            if (element.up !== undefined){
                that.navigateTo({
                    group: that.group.navigationGroup,
                    id: element.up({})
                });
            }
        };

        this.goDown = function () {
            var element = that.group.navigationElements[that.group.focused];
            if (element.down !== undefined) {
                that.navigateTo({
                    group: that.group.navigationGroup,
                    id: element.down({})
                });
            }
        };

        this.goLeft = function () {
            var element = that.group.navigationElements[that.group.focused];
            if (element.left !== undefined) {
                that.navigateTo({
                    group: that.group.navigationGroup,
                    id: element.left({})
                });
            }

        };

        this.goRight = function () {
            var element = that.group.navigationElements[that.group.focused];
            if (element.right !== undefined) {
                that.navigateTo({
                    group: that.group.navigationGroup,
                    id: element.right({})
                });
            }
        };

        this.goIn = function () {
            var element = that.group.navigationElements[that.group.focused];
            if (element.right !== undefined) {
                that.navigateTo({
                    group: that.group.navigationGroup,
                    id: element.right({})
                });
            }
        };


    });
