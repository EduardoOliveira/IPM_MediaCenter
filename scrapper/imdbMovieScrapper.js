var request = require('request');
var cheerio = require('cheerio');
var Database = new require('./MovieDatabase');
var movieDatabase = new Database('localhost', 27017, 'moviesDB');
module.exports = function (baseUrl) {
    var self = this;
    this.baseUrl = baseUrl;

    this.scrapMovie = function (movieUrl) {
        return request(this.baseUrl + movieUrl, (function (self) {
            return function (err, resp, body) {
                $ = cheerio.load(body);
                var genres = $(".infobar [itemprop='genre']");
                var movie = {
                    _id: movieUrl,
                    title: $('#overview-top h1.header span.itemprop[itemprop="name"]').text(),
                    genre0: genres.eq(0).text(),
                    genre1: genres.eq(1).text()
                };
                console.log(movie);
                movieDatabase.insertMovie(movie);
                self.scrapArtistsList({url: $('#titleCast .see-more a').eq(0).attribs.href});
                //this.scrapMovieDirectors({movieURL:movieUrl, movieBody:body});
            }
        })(this.self))
    };

    this.scrapArtistPage = function (params) {
        if (params.body !== undefined) {
            this._scrapArtistBody(params.body);
        } else {
            request(this.baseUrl + params.url, (function (self) {
                return function (err, resp, body) {
                    self._scrapArtistBody(body);
                }
            })(this.self));
        }
    };

    this.scrapArtistsList = function (params) {
        if (params.body !== undefined) {
            this._scrapArtistsListBody(params.body);
        } else {
            request(this.baseUrl + params.url, (function (self) {
                return function (err, resp, body) {
                    self._scrapArtistsListBody(body);
                }
            })(this.self));
        }
    };

    this._scrapArtistsListBody = function (body) {
        $ = cheerio.load(body);
        $('table.cast_list').each(function(){

        });
    };

    this._scrapArtistBody = function (body) {

    };

};


/*
 for (pool in pools) {
 var url = 'http://www.thprd.org/schedules/schedule.cfm?cs_id=' + pools[pool];

 request(url, (function(pool) { return function(err, resp, body) {
 $ = cheerio.load(body);
 $('#calendar .days td').each(function(day) {
 $(this).find('div').each(function() {
 event = $(this).text().trim().replace(/\s\s+/g, ',').split(',');
 if (event.length >= 2 && (event[1].match(/open swim/i) || event[1].match(/family swim/i)))
 console.log(pool + ',' + days[day] + ',' + event[0] + ',' + event[1]);
 });
 });
 }})(pool));
 }*/