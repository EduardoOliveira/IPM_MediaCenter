var request = require('request');
var cheerio = require('cheerio');
var Database = new require('./MovieDatabase');
var movieDatabase = new Database('128.199.52.250', 27017, 'moviesDB');
module.exports = function (baseUrl) {
    var self = this;
    this.baseUrl = baseUrl;

    this.scrapMovie = function (movieUrl) {
        return request(this.baseUrl + movieUrl, (function (self) {
            return function (err, resp, body) {
                if (err) {
                    return console.log(err);
                }
                $ = cheerio.load(body);
                var genres = $(".infobar [itemprop='genre']");
                var title = $('#overview-top h1.header span.title-extra[itemprop="name"]').text().match(/"(.*?)"/);
                if (title != null)
                    title = title[1];
                if (title == "" || title == null)
                    title = $('#overview-top h1.header span.itemprop[itemprop="name"]').text();
                var desc = $(".article.title-overview p[itemprop='description']").text();
                console.log(desc);
                console.log(title + ";");
                var movie = {
                    _id: movieUrl,
                    title: title,
                    genre0: genres.eq(0).text(),
                    genre1: genres.eq(1).text(),
                    description:desc
                };
                movieDatabase.insertMovie(movie);
            }
        })(this.self))
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