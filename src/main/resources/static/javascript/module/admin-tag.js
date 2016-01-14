/**
 * Created by HC on 2015/12/24.
 */
angular.module('admin.Tag', ['ngTable', 'ngResource'])

    .controller('TagCtrl', ['$scope', '$timeout', '$resource', '$filter', 'TagService', 'PicTypeService', 'AlertService',
        function ($scope, $timeout, $resource, $filter, TagService, PicTypeService, AlertService) {
            function listType() {
                TagService.listTagAll()
                    .success(function (data) {
                        $scope.tagList = data
                    });
            }

            listType();
            $scope.delete = function (id) {
                if (confirm("确定删除？")) {
                    TagService.delete(id).success(function (data) {
                        AlertService.show(data.success, data.msg, 3000);
                        listType();
                    })
                }
            };
            $scope.tag = {};
            $scope.updateShow = function (id) {
                TagService.findOne(id).success(function (data) {
                    $scope.tag = data
                });
                PicTypeService.listAll().success(function (data) {
                    $scope.typeList = data
                });
                $('#myModal').modal('toggle');
            };
            $scope.update = function () {
                TagService.update($scope.tag).success(function (data) {
                    AlertService.show(data.success, data.msg, 3000);
                    $('#myModal').modal('toggle');
                    listType();
                })
            }
        }
    ])
    .controller('TagAddCtrl', ['$scope', '$routeParams', '$modal', 'TagService', 'PicTypeService', 'AlertService',
        function ($scope, $routeParams, $modal, TagService, PicTypeService, AlertService) {
            $scope.tag = {};
            $scope.tag.picType = {};
            PicTypeService.listAll().success(function (data) {
                $scope.typeList = data
            });
            $scope.save = function () {
                var promise = TagService.save($scope.tag);
                AlertService.defaultHandle(promise, true);
            };
        }
    ]);
