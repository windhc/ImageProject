/**
 * Created by Administrator on 2015/9/1.
 */
angular.module('admin.Picture', ['ngTable', 'ngResource'])

    .controller('PictureCtrl', ['$scope', '$timeout', '$resource', '$filter', 'ngTableParams',
        function ($scope, $timeout, $resource, $filter, ngTableParams) {
            var Api = $resource('/atlas/atlasPage');

            $scope.test = "hhhh";


            $scope.tableParams = new ngTableParams({
                page: 1,            // show first page
                count: 5,          // count per page
                sorting: {
                    name: ''     // initial sorting
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
        }
    ])
    .controller('PictureAddCtrl', ['$scope', '$routeParams', '$modal',
        function ($scope, $routeParams, $modal) {

        }
    ]);
