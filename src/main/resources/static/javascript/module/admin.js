/**
 * Created by Administrator on 2015/8/8.
 */
angular.module('admin', ['main', 'admin.User'])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/user/:type', {
                templateUrl: 'res/admin/user/index.html',
                controller: 'UserController'
            }).when('/producer', {
                templateUrl: 'res/admin/producer/index.html',
                controller: 'ProducerController'
            }).when('/backup', {
                templateUrl: 'res/admin/backup/index.html',
                controller: 'BackupController'
            }).otherwise({ redirectTo: '/user/0'});
    }]);