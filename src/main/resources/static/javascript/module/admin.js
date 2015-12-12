/**
 * Created by Administrator on 2015/8/8.
 */
var ImageAdminApp = angular.module('ImageAdminApp', [
    'ngRoute', 'admin.Atlas', 'admin.Picture','common'
]);

ImageAdminApp.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/atlas/index', {
                templateUrl: '/atlas/index.html',
                controller: 'AtlasCtrl'
            }).when('/atlas/add', {
                templateUrl: '/atlas/add.html',
                controller: 'AtlasAddCtrl'
            }).when('/atlas/:id/detail', {
                templateUrl: '/atlas/detail.html',
                controller: 'AtlasDetailController'
            }).when('/atlas/:id/edit', {
                templateUrl: '/atlas/edit.html',
                controller: 'AtlasEditController'
            }).when('/picture/index', {
                templateUrl: '/picture/index.html',
                controller: 'PictureCtrl'
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
            },
            detail: function(id) {
                return $http.get("/atlas/detail/" + id);
            },
            update: function(atlas) {
                return $http.post("/atlas/update",atlas);
            }

        };
    }
]).service('PictureService', ['$http',
    function($http) {
        return {
            getPictureByAtlasId: function(atlasid) {
                return $http.get("/picture/byatlasid/"+atlasid);
            },
            delete: function(id) {
                return $http.get("/picture/delete/" + id);
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