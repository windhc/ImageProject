/**
 * Created by Administrator on 2015/9/13.
 */
angular.module('admin.Atlas', ['ngTable', 'ngResource', 'blueimp.fileupload'])

    .controller('AtlasCtrl', ['$scope', '$timeout', '$resource', '$filter', 'ngTableParams','AtlasService','AlertService',
        function ($scope, $timeout, $resource, $filter, ngTableParams,AtlasService,AlertService) {
            var Api = $resource('/atlas/atlasPage');

            $scope.tableParams = new ngTableParams({
                page: 1,            // show first page
                count: 5,           // count per page
                sorting: {
                    name: ''        // initial sorting
                }
            }, {
                counts: [20, 50, 100],
                //total: 2, // length of data
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

            $scope.delete = function(id){
                if(confirm("确定删除？")){
                    AtlasService.delete(id).success(function() {
                        AlertService.show(true,'删除成功',3000);
                        return $scope.tableParams.reload();
                    })
                }
            };
        }
    ])
    .controller('AtlasAddCtrl', ['$scope', '$routeParams','$http', '$filter', '$window',
        'PicTypeService','TagService', 'AtlasService', 'AlertService',
        function ($scope, $routeParams, $http, $filter, $window, PicTypeService, TagService, AtlasService, AlertService) {
            $scope.atlas = {};
            $scope.atlas.tagIds = [];
            $scope.atlas.files = [];

            PicTypeService.listAll().success(function(data) {
                $scope.picTypeList = data;
            });
            TagService.listTagAll().success(function(data) {
                $scope.tagList = data;
            });
            $scope.getPictypeTag = function(pictypeId) {
                TagService.findTagByPicTypeId(pictypeId).success(function(data) {
                    $scope.tagList = data;
                    $scope.atlas.tagIds = [];
                })
            };
            $scope.checkTag = function(tagId) {
                for(var i=0;i<$scope.atlas.tagIds.length;i++){
                    if($scope.atlas.tagIds[i]==tagId){
                        $scope.atlas.tagIds.splice(i,1);
                        return;
                    }
                }
                $scope.atlas.tagIds.push(tagId);
            };

            $scope.options = {
                maxFileSize: 10000000,
                url: '/web/upload'
            };
            $scope.loadingFiles = false;

            $scope.save = function(queue) {
                $scope.atlas.files = [];
                for(var i=0;i<queue.length;i++){
                    $scope.atlas.files.push(queue[i].url);
                }
                var promise = AtlasService.save($scope.atlas);
                AlertService.defaultHandle(promise, true);
            }
        }
    ])
    .controller('FileDestroyController', [
        '$scope', '$http',
        function ($scope, $http) {
            var file = $scope.file,
                state;
            if (file.url) {
                file.$state = function () {
                    return state;
                };
                file.$destroy = function () {
                    state = 'pending';
                    return $http({
                        url: file.deleteUrl,
                        method: file.deleteType
                    }).then(
                        function () {
                            state = 'resolved';
                            $scope.clear(file);
                        },
                        function () {
                            state = 'rejected';
                        }
                    );
                };
            } else if (!file.$cancel && !file._index) {
                file.$cancel = function () {
                    $scope.clear(file);
                };
            }
        }
    ])
    .controller('AtlasDetailController', [
        '$scope', '$routeParams', 'AtlasService', 'PictureService',
        function ($scope, $routeParams, AtlasService, PictureService) {
            AtlasService.detail($routeParams.id)
                .success(function(data){
                    $scope.atlas = data;
                });
            PictureService.getPictureByAtlasId($routeParams.id)
                .success(function(data){
                    $scope.pictures = data;
                });
        }
    ])
    .controller('AtlasEditController', [
        '$scope', '$routeParams', 'AtlasService', 'PictureService','PicTypeService','TagService','AlertService',
        function ($scope, $routeParams, AtlasService, PictureService, PicTypeService, TagService,AlertService) {
            $scope.atlas = [];
            $scope.atlas.tagIds = [];

            AtlasService.detail($routeParams.id)
                .success(function(data){
                    $scope.atlas = data;
                    TagService.findTagByPicTypeId($scope.atlas.picType.id).success(function(data) {
                        $scope.tagList = data;
                    });
                    $scope.atlas.tagIds = [];
                    for(var i=0;i<$scope.atlas.tags.length;i++){
                        $scope.atlas.tagIds.push($scope.atlas.tags[i].id);
                    }
                });
            PictureService.getPictureByAtlasId($routeParams.id)
                .success(function(data){
                    $scope.pictures = data;
                });

            PicTypeService.listAll().success(function(data) {
                $scope.picTypeList = data;
            });
            TagService.listTagAll().success(function(data) {
                $scope.tagList = data;
            });
            $scope.getPictypeTag = function(pictypeId) {
                TagService.findTagByPicTypeId(pictypeId).success(function(data) {
                    $scope.tagList = data;
                    $scope.atlas.tagIds = [];
                })
            };
            $scope.checkTag = function(tagId) {
                for(var i=0;i<$scope.atlas.tagIds.length;i++){
                    if($scope.atlas.tagIds[i]==tagId){
                        $scope.atlas.tagIds.splice(i,1);
                        return;
                    }
                }
                $scope.atlas.tagIds.push(tagId);
            };

            $scope.delete = function(id){
                if(confirm("确定删除？")){
                    PictureService.delete(id).success(function(data) {
                        AlertService.show(data.success,data.msg,3000);
                        PictureService.getPictureByAtlasId($routeParams.id).success(function(data){
                            $scope.pictures = data;
                        });
                    })
                }
            };

            $scope.options = {
                maxFileSize: 10000000,
                url: '/web/upload'
            };
            $scope.loadingFiles = false;

            $scope.save = function(queue) {
                $scope.atlas.files = [];
                for(var i=0;i<queue.length;i++){
                    $scope.atlas.files.push(queue[i].url);
                }
                $scope.atlas.picTypeId = $scope.atlas.picType.id;

                console.log($scope.atlas);
                var promise = AtlasService.update($scope.atlas);
                AlertService.defaultHandle(promise, true);
            }
        }
    ]);
