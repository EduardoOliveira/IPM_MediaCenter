'use strict';

angular.module('mediaCenter.core.services', [])
    .service('NavigationService', function ($timeout,$rootScope) {
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
            var current = $('[data-navigation-group="' + params.group + '"][data-navigation-id].focused');
            var next = $('[data-navigation-group="' + params.group + '"][data-navigation-id="' + params.id + '"]');
            this.graphicalNavigation.focus({
                current: current,
                next: next
            });
            this.group.focused = params.id;
        };

        this.goIn = function () {
            $timeout(function () {
                $('[data-navigation-group="' + that.group.navigationGroup + '"][data-navigation-id].focused').click();
            });
        };

        this.goUp = function () {
            var element = that.group.navigationElements[that.group.focused];
            if (element.up !== undefined) {
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

    })
    .service('WebSocketService', function ($websocket,$rootScope) {
        var dataStream = $websocket('ws://' + document.location.host + '/websocket');

        dataStream.onOpen(function () {
            console.log('Oh my gosh, websocket is really open! Fukken awesome!');

            dataStream.send(
                {
                    "event": 'pt.iscte.ipm.mediacenter.core.events.ConnectEvent',
                    "handler": 'pt.iscte.ipm.mediacenter.websocket.handling.ConnectEventHandler',
                    "data": {
                        "deviceType": "pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice",
                        "deviceName": "MainSession"//TODO: CHANGE ME!
                    }
                });
            var data = {"keyCode": "wqeqe"};

            //dataStream.send('pt.iscte.ipm.mediacenter.remote.events.NavigationEvent', data);

            dataStream.onMessage(function(data){
                $rootScope.$broadcast(data.event,data);
            });
        });

        dataStream.onClose(function () {
            console.log('Noooooooooou, I want to have more fun with ngWebsocket, damn it!');
        });
    });
