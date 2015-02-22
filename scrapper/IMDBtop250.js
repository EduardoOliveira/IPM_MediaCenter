var request = require('request');
var cheerio = require('cheerio');
var imdbMovieScrapper = require('./imdbMovieScrapper');
var baseURL = "http://akas.imdb.com";
var listPath = "/chart/top";

request(baseURL + listPath, function (err, resp, body) {
    $ = cheerio.load(body);
    var scrapper = new imdbMovieScrapper(baseURL);
    $("tbody.lister-list td.titleColumn a").each(function () {
        scrapper.scrapMovie(this.attribs.href);
    });
});


