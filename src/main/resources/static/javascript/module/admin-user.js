/**
 * Created by Administrator on 2015/8/8.
 */
angular.module('admin.User', ['ngTable', 'ngResource'])

    .controller('UserCtrl', ['$scope', '$timeout', '$resource', '$filter', 'ngTableParams', 'UserService', 'AlertService',
        function ($scope, $timeout, $resource, $filter, ngTableParams, UserService, AlertService) {
            var Api = $resource('/user/userPage');
            $scope.tableParams = new ngTableParams({
                page: 1,            // show first page
                count: 15,           // count per page
                sorting: {
                    name: ''        // initial sorting
                }
            }, {
                counts: [20, 30, 50],
                getData: function ($defer, params) {
                    // ajax request to api
                    Api.get(params.url(), function (data) {
                        $timeout(function () {
                            // update table params
                            params.total(data.totalElements);
                            console.log(data);
                            // set new data
                            $defer.resolve(data.content);
                        }, 100);
                    });
                }
            });
            $scope.delete = function (id) {
                if (confirm("确定删除？")) {
                    UserService.delete(id).success(function (data) {
                        AlertService.show(data.success, data.msg, 3000);
                        return $scope.tableParams.reload();
                    })
                }
            };
        }
    ])
    .controller('UserAddCtrl', ['$scope', '$routeParams', '$modal', 'UserService', 'AlertService',
        function ($scope, $routeParams, $modal, UserService, AlertService) {
            $scope.user = {};
            $scope.save = function () {
                var promise = UserService.save($scope.user);
                AlertService.defaultHandle(promise, true);
            };
        }
    ]);
