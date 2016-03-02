/**
 * Created by Administrator on 2015/9/13.
 */
angular.module('index.Main', ['ngTable', 'ngResource'])

    .controller('ImageCtrl', ['$scope', '$timeout', '$resource', '$filter', '$location', 'ngTableParams','ImageService',
        function ($scope, $timeout, $resource, $filter, $location, ngTableParams, ImageService) {

            function getAtlasPageByType(typeId) {
                $scope.params= "?page=1&count=5&type="+typeId;
                ImageService.atlasPage($scope.params).success(function(data) {
                    $scope.atlases = data;
                });
            }
            //得到所有的分类
            ImageService.listAllPicType().success(function(data) {
                return $scope.types = data
            });
            //页面手动刷新时显示标签及active样式，和此分类下的图册
            var typeId = $location.path().substr($location.path().lastIndexOf('/')+1);
            if(typeId) {
                getAtlasPageByType(typeId);
                ImageService.listTagByType(typeId).success(function(data) {
                    $('.nav li').removeClass('active');
                    $('#'+typeId).addClass('active');
                    return $scope.tags = data;
                });
            } else {
                //默认显示全部分类的数据
                $scope.params= "?page=1&count=5";
                ImageService.atlasPage($scope.params).success(function(data) {
                    //console.log(data);
                    $scope.atlases = data;
                });
            }
            $scope.selected = {};
            //响应选择分类的事件
            $scope.selectType = function (typeId) {
                $('.nav li').removeClass('active');
                $('#'+typeId).addClass('active');
                ImageService.listTagByType(typeId).success(function(data) {
                    return $scope.tags = data;
                });
                getAtlasPageByType(typeId);
                $scope.selected = {};
            };

            $scope.tagClick = function (tagId) {
                if ($scope.selected[tagId]==true) {
                    $('#'+tagId).removeClass('label-primary');
                    $('#'+tagId).addClass('label-default');
                    $scope.selected[tagId] = false;
                } else {
                    $('#'+tagId).removeClass('label-default');
                    $('#'+tagId).addClass('label-primary');
                    $scope.selected[tagId] = true;
                }
                var tagIds = '';
                for(var key in $scope.selected){
                    if($scope.selected[key]){
                        tagIds = key+tagIds;
                    }
                }
                $scope.params= "?page=1&count=5&tag="+tagIds;
                ImageService.atlasPage($scope.params).success(function(data) {
                    $scope.atlases = data;
                });
            };

            //翻页
            $scope.getPage =function(page) {
                console.log(page);
            }
        }
    ]);
