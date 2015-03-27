var bson = require('bson');
var MongoClient = require('mongodb').MongoClient;

module.exports = function (server, port, database) {
    this.server = server;
    this.port = port;
    this.database = database;

    this.insertMovie = function (movie) {

        MongoClient.connect('mongodb://rute:pfleotesla1@' + this.server + ':' + this.port + '/' + this.database + '?authSource=admin', function (err, db) {
            if (err) throw err;
            var collection = db.collection('movies');
            collection.update({_id: movie._id}, movie, {upsert: true}, function (err, docs) {
                if(err!=null)
                    console.error(err);
            });
        });
    };
};
