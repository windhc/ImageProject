/**
 * Created by Administrator on 2015/9/1.
 */
angular.module('admin.Picture', ['ngTable', 'ngResource'])

    .controller('PictureCtrl', ['$scope', '$timeout', '$resource', '$filter', 'ngTableParams','PictureService','AlertService',
        function ($scope, $timeout, $resource, $filter, ngTableParams, PictureService, AlertService) {
            var Api = $resource('/picture/picturePage');

            $scope.tableParams = new ngTableParams({
                page: 1,            // show first page
                count: 20,           // count per page
                sorting: {
                    name: ''        // initial sorting
                }
            }, {
                counts: [50, 100, 200],
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
                    PictureService.delete(id).success(function(data) {
                        AlertService.show(data.success,data.msg,3000);
                        return $scope.tableParams.reload();
                    })
                }
            };
            $scope.showPopover = function(id){
                $("#"+id).popover('toggle');
            };
        }
    ])
    .controller('PictureAddCtrl', ['$scope', '$routeParams', '$modal',
        function ($scope, $routeParams, $modal) {

        }
    ]);
