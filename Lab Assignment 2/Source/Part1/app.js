var app = angular.module('app', []);

app.factory('$tictactoe', ['$timeout', function($timeout) {
    return function(grid_size) {

        this.grid_size = grid_size;

        this.init = function() {
            this.scores = {
                X: 0,
                O: 0
            };
            this.marks = {
                X: 'X',
                O: 'O',
                count: 0
            };
            this.newArray = new Array(this.grid_size);
            this.data = {};
        };

        this.empty = function() {
            this.data = {};
            this.marks.count = 0;
        };

        this.mark = function(row_index, column_index) {

            var self = this;
            if(self.data[row_index + '' + column_index]) {
                return;
            }
            self.marks.count++;
            var current_mark = self.marks.count % 2 === 1 ? self.marks.X : self.marks.O;
            self.data[row_index + '' + column_index] = current_mark;
            $timeout(function(){
                if (self.Win(current_mark)) {
                    alert(current_mark+" has won");
                    self.scores[self.marks.count % 2 === 1 ? 'X' : 'O']++;
                    self.empty();
                } else if (self.marks.count == self.grid_size * self.grid_size) {
                    alert("It's a draw !");
                    self.empty();
                }
            });
        };

        this.Win = function(mark) {

            var CountVertical = 0,
                CountHorizontal = 0,
                CountLeftRight = 0,
                CountRightLeft = 0;
            for (var i = 0; i < this.grid_size; i++) {
                CountVertical = 0;
                CountHorizontal = 0;
                for (var j = 0; j < this.grid_size; j++) {
                    if (this.data[i + '' + j] == mark) {
                        CountHorizontal++;
                    }
                    if (this.data[j + '' + i] == mark) {
                        CountVertical++;
                    }
                }
                if (this.data[i + '' + i] == mark) {
                    CountLeftRight++;
                }
                if (this.data[(this.grid_size - 1 - i) + '' + i] == mark) {
                    CountRightLeft++;
                }
                if (CountHorizontal == this.grid_size || CountVertical == this.grid_size) {
                    return true;
                }
            }
            if(CountLeftRight == this.grid_size || CountRightLeft == this.grid_size) {
                return true;
            }
            return false;
        };

        this.init();

        return this;

    };
}]);

app.controller('TicTacToeCtrl', ['$scope', '$tictactoe', function($scope, $tictactoe) {

    $scope.grid_options = [{
        value: 3,
        label: '3 X 3'
    }, {
        value: 4,
        label: '4 X 4'
    }, {
        value: 5,
        label: '5 X 5'
    }];

    $scope.game = new $tictactoe(3);

}]);