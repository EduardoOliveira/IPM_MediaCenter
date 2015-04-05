'use strict';

angular.module('mediaCenter.core.services', [])
    .service('NavigationService', function () {
        this.navigationGroups = [];
        this.previousGroupName = "";
        this.activeGroupName = "";
        this.activeGroup = {};
        this.graphicalNavigation = new GraphicalNavigation();
        var that = this;

        this.registerNavigationGroup = function (group) {
            this.navigationGroups[group.name] = group;
        };

        this.setActiveGroup = function (name) {
            this.previousGroupName = this.activeGroupName;
            this.activeGroupName = name;
            this.activeGroup = this.navigationGroups[name];
            this.activeGroup.focused = this.navigationGroups[name].default;
            if(this.activeGroup.onEnter != undefined) this.activeGroup.onEnter();
            this.navigateTo(this.activeGroup.default);
        };

        this.navigateTo = function (next) {
            that.activeGroup.previous = that.activeGroup.focused;
            that.activeGroup.focused = next;
            var $current = $('[data-navigation-group="' + this.activeGroupName + '"][data-navigation-id].focused');
            var $next = $('[data-navigation-group="' + this.activeGroupName + '"][data-navigation-id="' + next + '"]');
            this.graphicalNavigation.focus({current: $current, next: $next});
        };

        this.goIn = function () {
            var element = that.activeGroup.navFn(that.activeGroup.focused);
            if (element.in !== undefined) {
                element.in({});
            }
        };

        this.goUp = function () {
            var element = that.activeGroup.navFn(that.activeGroup.focused);
            if (element.up !== undefined) {
                that.navigateTo(element.up({}));
            }
        };

        this.goDown = function () {
            var element = that.activeGroup.navFn(that.activeGroup.focused);
            if (element.down !== undefined) {
                that.navigateTo(element.down({}));
            }
        };

        this.goLeft = function () {
            var element = that.activeGroup.navFn(that.activeGroup.focused);
            if (element.left !== undefined) {
                that.navigateTo(element.left({}));
            }
        };

        this.goRight = function () {
            var element = that.activeGroup.navFn(that.activeGroup.focused);
            if (element.right !== undefined) {
                that.navigateTo(element.right({}));
            }
        };

        this.goBack = function () {

        };

        this.goDevices = function () {
            that.setActiveGroup('devices');
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
                }, 2000);
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

    })
    .service('LoadingService', function () {
        this.loaders = 0;
        this.start=function(){
            this.loaders++;
        };

        this.stop=function(){
            this.loaders--;
        };
    });
