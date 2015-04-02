'use strict';

angular.module('mediaCenter.core.services', [])
    .service('NavigationService', function ($timeout) {
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
    .service('WebSocketService', function ($websocket, $rootScope) {
        var dataStream = $websocket.$new('ws://' + document.location.host + '/websocket');
        var lastPing = 0;
        dataStream.$on('$open', function () {
            console.log('Oh my gosh, websocket is really open! Fukken awesome!');

            dataStream.$emit('pt.iscte.ipm.mediacenter.core.events.ConnectEvent', {
                "handler": 'pt.iscte.ipm.mediacenter.playback.handling.ConnectEventHandler',
                "deviceName": "MainSession"//TODO: CHANGE ME!
            });

            function timeout() {
                setTimeout(function () {
                    lastPing = Date.now();
                    dataStream.$emit('pt.iscte.ipm.mediacenter.core.events.Ping', {
                        handler: "pt.iscte.ipm.mediacenter.websocket.handling.PingPongHandler",
                        timeStamp: lastPing
                    });
                    timeout();
                },2000);
            }

            timeout();
        });

        dataStream.$on('pt.iscte.ipm.mediacenter.core.events.Pong', function (event) {
            $rootScope.$broadcast("pong", {latency: ((new Number(event.timeStamp)) - lastPing)});
        });

        dataStream.$on('$close', function () {
            console.log('Noooooooooou, I want to have more fun with ngWebsocket, damn it!');
        });

        this.register = function (event, handler) {
            dataStream.$on(event, handler);
        };

        this.unregister = function (event) {
            dataStream.$un(event);
        };

    });
