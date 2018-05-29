app.controller('appController', ["$scope", "$log", "appService",
    function($scope, $log, appService) {
        $scope.firstName= "John";
        $scope.lastName= "Doe";
        $scope.reps= appService.getReps();

        $scope.loadReps = function () {
            var promiseGet = appService.getReps();
            promiseGet.then(function (result) {
                if (result && result.data) {
                    $scope.reps = result.data;
                }
            }, function (reason) {
                $log.error("failure loading database information", reason);
            });
        };

        $scope.loadReps();

}]);