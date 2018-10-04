
angular.module('youTubeApp', [])
    .config(function($sceDelegateProvider) {
        $sceDelegateProvider.resourceUrlWhitelist([
            'self',
            'https://www.youtube.com/**'
        ])
    })
    .controller('AppCtrl', function ($scope, $http) {
        $scope.videoList = new Array();

        $scope.getResults = function () {
            var query = document.getElementById("query").value;
            var key = "AIzaSyCz-C16fMr9Gk3kARZOTrtsVJihu15117U";
            var baseUrl = "https://www.googleapis.com/youtube/v3/search";
            if (query != null && query != "") {
                var url = baseUrl +
                    "?key=" + key +
                    "&part=snippet" +
                    "&type=video" +
                    "&videoEmbeddable=true" +
                    "&q=" + query;

                $http.get(url)
                    .success(function (response) {
                        $scope.videoList = response.items;
                    });
            } else {
                alert("Please enter a search query.");
            }
        };

        $scope.getVidUrl = function (id) {
            return "https://www.youtube.com/embed/" + id;
        }
    });
