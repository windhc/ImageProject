/**
 * Created by HC on 2016/1/15.
 */
/**
 * Created by Administrator on 2015/8/8.
 */
angular.module('admin.System', ['ngResource'])

    .controller('PwdCtrl', ['$scope', '$timeout', '$resource', '$filter', 'SystemService', 'AlertService',
        function ($scope, $timeout, $resource, $filter, SystemService, AlertService) {
            $scope.pwds = {};
            $scope.save = function () {
                var promise = SystemService.updatePwd($scope.pwds);
                AlertService.defaultHandle(promise, true);
            };
        }
    ])
    .controller('AddCtrl', ['$scope', '$routeParams', '$modal', 'SystemService', 'AlertService',
        function ($scope, $routeParams, $modal, SystemService, AlertService) {
            $scope.user = {};
            $scope.save = function () {
                var promise = SystemService.save($scope.user);
                AlertService.defaultHandle(promise, true);
            };
        }
    ]);
