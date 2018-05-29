app.service('appService', ["$http", function ($http) {

    this.getReps = function () {
        return $http.get("rep");
    };

}]);