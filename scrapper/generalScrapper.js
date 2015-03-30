var request = require('request');
var cheerio = require('cheerio');
var imdbMovieScrapper = require('./imdbMovieScrapper');
var baseURL = "http://akas.imdb.com";

scrap({url_base: baseURL, url_path: process.argv[2], selector: process.argv[3]});

function scrap(params) {
    console.log(params.url_base + params.url_path);
    request(params.url_base + params.url_path, function (err, resp, body) {
        $ = cheerio.load(body);
        var scrapper = new imdbMovieScrapper(baseURL);
        $(params.selector).each(function () {
            scrapper.scrapMovie(this.attribs.href);
        });
        if ($('.article .see-more a') != null && $('.article .see-more a')[0] != undefined) {
            console.log($('.article .see-more a')[0].attribs.href);
            scrap({
                url_base: params.url_base,
                url_path: $('.article .see-more a')[0].attribs.href,
                selector: params.selector
            });
        }
        if ($('#main .pagination a:contains("»")') != null && $('#main .pagination a:contains("»")')[0] != undefined) {
            console.log($('#main .pagination a:contains("»")')[0].attribs.href);
            scrap({
                url_base: params.url_base,
                url_path: $('#main .pagination a:contains("»")')[0].attribs.href,
                selector: params.selector
            });
        }

    });
}