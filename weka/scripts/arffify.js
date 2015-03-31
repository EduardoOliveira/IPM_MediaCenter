//example nodejs arffify.js Blood desc_full

var bson = require('bson');
var MongoClient = require('mongodb').MongoClient;
var fs = require('fs');

MongoClient.connect('mongodb://root:2kyydv966gt2@knoker.no-ip.org/moviesDB?authSource=admin', function (err, db) {
    if (err) throw err;
    var collection = db.collection('movies');
    var str = "";
    var cluster = process.argv[2];
    var field = process.argv[3];
    collection.find().toArray(function (err, docs) {
        if (err) throw err;
        docs.forEach(function (doc) {
            str += "\n\'" + doc[field].trim().replace(/\r?\n|\r/g, " ").replace(/\s+/g, ' ').replace(/'/g, "\\'") + "\'," + (doc.clusters[cluster] == 'true' ? 'yes' : 'no');
        });
        console.log(str);
        fs.appendFile('../clusters/'+cluster+'.arff', str, function (err) {
            if (err) throw err;
        });
    });
});