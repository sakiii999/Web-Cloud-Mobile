console.log("The bot is starting");

var Twit = require('twit');
var d3 = require("d3");
var fs = require("fs");
var config = require('./config');

//console.log(config);


var T = new Twit(config);

T.get('friends/list', { screen_name: 'jyotimunde13' },  function (err, data, response) {
    console.log(data);

    var fileContent = data;

    fs.writeFile("./twitter.json",  JSON.stringify(fileContent,null,2), function (error,filecontent) {

        if (err) {
            console.error(err);
            return;
        };
        console.log("Got Friend list successfully");
    });

});

