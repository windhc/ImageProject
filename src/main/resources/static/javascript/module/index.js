/**
 * Created by HC on 2016/1/24.
 */

/**
 * Created by Administrator on 2015/8/8.
 */
var ImageApp = angular.module('ImageApp', [
    'common', 'ngRoute', 'index.Main'
]);

ImageApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/picture/index', {
            templateUrl: '/view/picture/index.html',
            controller: 'PictureCtrl'
        })
        .otherwise({redirectTo: '/picture/index'});
}]);

ImageApp.service('ImageService', ['$http',
    function($http) {
        return {
            listAllPicType: function() {
                return $http.get("/pictype/list");
            },
            listTagByType: function(tagId) {
                return $http.get("/tag/pictypetag/"+tagId);
            },
            atlasPage: function (params) {
                return $http.get("/atlas/front/atlasPage"+ params);
            }
        };
    }
]);