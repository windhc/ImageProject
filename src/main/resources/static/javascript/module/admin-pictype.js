/**
 * Created by HC on 2015/12/24.
 */
angular.module('admin.PicType', ['ngTable', 'ngResource'])

    .controller('PicTypeCtrl', ['$scope', '$timeout', '$resource', '$filter', 'ngTableParams', 'PicTypeService', 'AlertService',
        function ($scope, $timeout, $resource, $filter, ngTableParams, PicTypeService, AlertService) {
            function listType() {
                PicTypeService.listAll()
                    .success(function (data) {
                        $scope.typeList = data
                    });
            }

            listType();
            $scope.delete = function (id) {
                if (confirm("确定删除？")) {
                    PicTypeService.delete(id).success(function (data) {
                        AlertService.show(data.success, data.msg, 3000);
                        listType();
                    })
                }
            };
            $scope.type = {};
            $scope.updateShow = function (id, typeName) {
                $('#myModal').modal('toggle');
                $scope.type.id = id;
                $scope.type.typeName = typeName;
            };
            $scope.update = function () {
                PicTypeService.update($scope.type).success(function (data) {
                    AlertService.show(data.success, data.msg, 3000);
                    $('#myModal').modal('toggle');
                    listType();
                })
            }
        }
    ])
    .controller('PicTypeAddCtrl', ['$scope', '$routeParams', '$modal', 'PicTypeService', 'AlertService',
        function ($scope, $routeParams, $modal, PicTypeService, AlertService) {
            $scope.type = {};
            $scope.save = function () {
                var promise = PicTypeService.save($scope.type);
                AlertService.defaultHandle(promise, true);
            };
        }
    ]);
