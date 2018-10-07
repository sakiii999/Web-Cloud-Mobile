$(document).ready(function () {

    //var Twitter = require('twit');
    //var twitterAuth = require('twitter-oauth')({
    //    consumerKey: "PS8tSaiHnvm3oMucUG2Gux4ID", /* per appication - create a comsumer key here: https://dev.twitter.com/apps */
    //    domain: 'http://localhost',
    //    consumerSecret: "5yBgCTor61Er41MagNarvPhZw0hui4di1ZR0UBpMDOIIdyGUdH", /* create a comsumer key here: https://dev.twitter.com/apps */
    //    loginCallback: "http://localhost/twitter/sessions/callback",  /* internal */
    //    completeCallback: "http://localhost/home"  /* When oauth has finished - where should we take the user too */
    //});

//    var oauth = new OAuth.OAuth(
//    'https://api.twitter.com/oauth/request_token',
//    'https://api.twitter.com/oauth/access_token',
//    config.twitterConsumerKey,
//    config.twitterSecretKey,
//    '1.0A',
//    null,
//    'HMAC-SHA1'
//);

    var twit = require('twitter-oauth');
    var username = "sakiii999";
    var config = {
        "consumer_key": "tKjAlq75QJSELD1ncErDk3N2xq",
        "consumer_secret": "Hy1xxbAbCB4CtT3pLiWIQIRvYkP1hHHDnleyuN3E5GW1XnLSax",
        "access_token": "166984191-cnBgBG6siwy3CXsUJB7zUH8dGmhn5uWCgRPzAJa9",
        "access_token_secret": "1KFcpf7txSW1ElzZysvRbK5RbCQdMwM9xHlz6kjFECyLf"
    }
    //var twitter = new Twitter(config);
    var twt = new twit(config);
    twt.get('favorites/list', function (error, tweets, response) {
        if(error) throw error;
        console.log(tweets);  //FAV
        console.log(response);  // RAW OBJECT.
    });
});