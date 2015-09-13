/**
 * Created by Administrator on 2015/8/8.
 */
var ImageAdminApp = angular.module('ImageAdminApp', [
    'ngRoute', 'admin.Picture'
]);

ImageAdminApp.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/index', {
                templateUrl: '/module/picture/index.html',
                controller: 'PictureCtrl'
            })
            .when('/add', {
                templateUrl: '/module/picture/add.html',
                controller: 'PictureAddCtrl'
            }).otherwise({ redirectTo: '/index'});
    }]);

ImageAdminApp.service('UserService', [
    '$http', function($http) {
        return {
            getPage: function() {
                return $http.post("/picture/picturePage");
            }
        };
    }
]);