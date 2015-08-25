//= require app/angular-atmosphere-service.js
//= require module/common.js
angular.module('action.bar', ['common'])

    .controller('ActiveMQController',
    ['$scope', function($scope) {

    }])

    .controller('GlobalActionController',
    ['$scope', '$rootScope', '$location', '$http', 'DialogService', 'WebSocketService',
        function ($scope, $rootScope, $location, $http, DialogService, WebSocketService) {
            $scope.changePassword = function () {
                DialogService.show({
                    templateUrl: 'assets/system/user/changePasswdModal.html',
                    controller: 'ChangePasswordModalController'
                });
            };

            WebSocketService.init('guest', 'guest123');
        }])

    .controller('ChangePasswordModalController',
    ['$scope', '$http', '$modalInstance', 'FormService', 'ActionService',
        function ($scope, $http, $modalInstance, FormService, ActionService) {
            FormService.init($scope);

            $scope.user = {};

            $scope.isValid = function() {
                return FormService.canSave($scope.userForm) &&
                $scope.user.confirmPassword &&
                $scope.user.newPassword;
            };

            $scope.ok = function () {
                ActionService.changePassword($scope.user.originalPassword, $scope.user.newPassword)
                    .success(function (data, status, headers, config) {
                        location.href = 'TrustApp/j_spring_security_logout';
                    })
                    .error(function (data, status, headers, config) {
                        $modalInstance.close({success: false, data: '网络异常!'});
                    });
            };

            $scope.cancel = function () {
                $modalInstance.dismiss('cancel');
            };
        }])

    .service('ActionService', ['$http', function($http) {
        var instance = {};
        instance.checkPassword = function(password) {
            return $http.post('user/checkPassword', {password: password});
        };
        instance.changePassword = function(originalPassword, newPassword) {
            return $http.post('user/changePassword', {
                'originalPassword': originalPassword,
                'newPassword': newPassword
            });
        };
        return instance;
    }])

    .directive('passwordValidator',
    ['$http', '$q', 'ActionService', function($http, $q, ActionService) {
        return {
            require: 'ngModel',
            link: function($scope, element, attrs, ngModel) {
                ngModel.$asyncValidators.passwordAvailable = function(password) {
                    return ActionService.checkPassword(password)
                        .then(function(response) {
                            if (!response.data.success) {
                                return $q.reject(response.data.data);
                            }
                            return true;
                        });
                };
            }
        };
    }])

    .directive('validateEquals', function() {
        return {
            require: 'ngModel',
            link: function(scope, elm, attrs, ngModelCtrl) {
                function validateEqual(myValue) {
                    var valid = (myValue === scope.$eval(attrs.validateEquals));
                    ngModelCtrl.$setValidity('equal', valid);
                    return valid ? myValue : undefined;
                }
                ngModelCtrl.$parsers.push(validateEqual);
                ngModelCtrl.$formatters.push(validateEqual);
                scope.$watch(attrs.validateEquals, function() {
                    ngModelCtrl.$setViewValue(ngModelCtrl.$viewValue);
                });
            }
        };
    });