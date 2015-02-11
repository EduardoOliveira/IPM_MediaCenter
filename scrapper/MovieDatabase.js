var bson = require('bson');
var MongoClient = require('mongodb').MongoClient;

module.exports = function (server, port, database) {
    this.server = server;
    this.port = port;
    this.database = database;

    this.insertMovie = function (movie) {

        MongoClient.connect('mongodb://' + this.server + ':' + this.port + '/' + this.database, function (err, db) {
            if (err) throw err;
            var collection = db.collection('movies');
            collection.update({_id: movie._id}, movie, {upsert: true}, function (err, docs) {
                console.log(err);
            });
        });
    };

    this.insertActor = function (actor) {
        MongoClient.connect('mongodb://' + this.server + ':' + this.port + '/' + this.database, function (err, db) {
            if (err) throw err;
            var collection = db.collection('movies');
            collection.update({_id: actor._id}, actor, {upsert: true}, function (err, docs) {
                console.log(err);
            });
        });
    };

    this.insertDirector = function (director) {
        MongoClient.connect('mongodb://' + this.server + ':' + this.port + '/' + this.database, function (err, db) {
            if (err) throw err;
            var collection = db.collection('movies');
            collection.update({_id: director._id}, director, {upsert: true}, function (err, docs) {
                console.log(err);
            });
        });
    }
};
