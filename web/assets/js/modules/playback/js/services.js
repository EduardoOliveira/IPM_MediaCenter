'use strict';

angular.module('mediaCenter.playback.services', [])
    .service('PlaybackStateService', function () {
        this.progress=0;
        this.loaded=0;
        this.state="playing";

    });
