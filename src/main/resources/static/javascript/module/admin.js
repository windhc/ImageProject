/**
 * Created by Administrator on 2015/8/8.
 */
var ImageAdminApp = angular.module('ImageAdminApp', [
    'common', 'ngRoute', 'admin.Atlas', 'admin.Picture', 'admin.PicType', 'admin.Tag', 'admin.User', 'admin.System'
]);

ImageAdminApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/picture/index', {
            templateUrl: '/view/picture/index.html',
            controller: 'PictureCtrl'
        }).when('/atlas/index', {
        templateUrl: '/view/atlas/index.html',
                controller: 'AtlasCtrl'
            }).when('/atlas/add', {
        templateUrl: '/view/atlas/add.html',
                controller: 'AtlasAddCtrl'
            }).when('/atlas/:id/detail', {
        templateUrl: '/view/atlas/detail.html',
                controller: 'AtlasDetailController'
            }).when('/atlas/:id/edit', {
        templateUrl: '/view/atlas/edit.html',
                controller: 'AtlasEditController'
    }).when('/pictype', {
        templateUrl: '/view/pictype/index.html',
        controller: 'PicTypeCtrl'
    }).when('/pictype/add', {
        templateUrl: '/view/pictype/add.html',
        controller: 'PicTypeAddCtrl'
    }).when('/tag', {
        templateUrl: '/view/tag/index.html',
        controller: 'TagCtrl'
    }).when('/tag/add', {
        templateUrl: '/view/tag/add.html',
        controller: 'TagAddCtrl'
    }).when('/user', {
        templateUrl: '/view/user/index.html',
        controller: 'UserCtrl'
    }).when('/user/add', {
            templateUrl: '/view/user/add.html',
            controller: 'UserAddCtrl'
    }).when('/pwd', {
            templateUrl: '/view/system/pwd.html',
            controller: 'PwdCtrl'
        })
        .otherwise({redirectTo: '/picture/index'});
    }]);

ImageAdminApp.service('UserService', ['$http',
    function($http) {
        return {
            getPage: function() {
                return $http.post("/picture/picturePage");
            },
            delete: function (id) {
                return $http.get("/user/delete/" + id);
            },
            save: function (user) {
                return $http.post("/user/save", user);
            },
            findOne: function (id) {
                return $http.get("/user/" + id);
            },
            update: function (user) {
                return $http.post("/user/update", user);
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
            },
            save: function (pictype) {
                return $http.post("/pictype/save", pictype);
            },
            delete: function (id) {
                return $http.get("/pictype/delete/" + id);
            },
            update: function (pictype) {
                return $http.post("/pictype/update", pictype);
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
            },
            findOne: function (id) {
                return $http.get("/tag/" + id);
            },
            save: function (tag) {
                return $http.post("/tag/save", tag);
            },
            delete: function (id) {
                return $http.get("/tag/delete/" + id);
            },
            update: function (tag) {
                return $http.post("/tag/update/", tag);
            }
        };
    }
]).service('SystemService', ['$http',
    function ($http) {
        return {
            updatePwd: function (pwds) {
                return $http.post("/admin/updateCurrentPwd", pwds);
            }
        }
    }
]);