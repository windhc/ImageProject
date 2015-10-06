/**
 * Created by Administrator on 2015/8/8.
 */
var ImageAdminApp = angular.module('ImageAdminApp', [
    'ngRoute', 'admin.Atlas'
]);

ImageAdminApp.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/atlas/index', {
                templateUrl: '/module/atlas/index.html',
                controller: 'AtlasCtrl'
            }).when('/atlas/add', {
                templateUrl: '/module/atlas/add.html',
                controller: 'AtlasAddCtrl'
            }).when('/atlas/add', {
                templateUrl: '/module/atlas/add.html',
                controller: 'AtlasAddCtrl'
            }).otherwise({ redirectTo: '/atlas/index'});
    }]);

ImageAdminApp.service('UserService', ['$http',
    function($http) {
        return {
            getPage: function() {
                return $http.post("/picture/picturePage");
            }
        };
    }
]).service('AtlasService', ['$http',
    function($http) {
        return {
            delete: function(id) {
                return $http.get("/atlas/delete/" + id);
            },
            tag: function(id) {
                return $http.get("/atlas/tag/" + id);
            },
            save: function(atlas) {
                return $http.post("/atlas/save",atlas);
            }
        };
    }
]).service('PicTypeService', ['$http',
    function($http) {
        return {
            listAll: function() {
                return $http.get("/pictype/list");
            }
        };
    }
]).service('TagService', ['$http',
    function($http) {
        return {
            listTagAll: function() {
                return $http.get("/tag/listTagAll");
            },
            findTagByPicTypeId: function(pictypeId) {
                return $http.get("/tag/pictypetag/"+pictypeId);
            }
        };
    }
]);