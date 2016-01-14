angular.module('common', ['ui.bootstrap'])

    .service('AlertService', ['$timeout', '$location',
    function($timeout, $location) {
        return {
            //alerts: [
            //    { type: 'danger', msg: 'Oh snap! 11111.' },
            //    { type: 'success', msg: 'Well done! You successfully .' }
            //],
            //defaultHandle: function(){
            //    console.log("nihao");
            //}
            alerts: [],
            init: function(scope) {
                return scope.AlertService = this;
            },
            dismiss: function(index) {
                return this.alerts.splice(index, 1);
            },
            show: function(success, message, time) {
                time = time != null ? time : 3000;
                this.alerts.push({
                    type: (success ? 'success' : 'danger'),
                    msg: message
                });
                return $timeout(((function(_this) {
                    return function() {
                        return _this.dismiss(0);
                    };
                })(this)), time);
            },
            defaultHandle: function(promise, backAfterSuccess, successMessage, errorMessage) {
                var goBack;
                goBack = function() {
                    var arr;
                    arr = $location.path().split('/');
                    arr.pop();
                    return $location.path(arr.join('/'));
                };
                return promise.success((function(_this) {
                    return function(data, status, headers, config) {
                        _this.show(data.success, data.msg ? data.msg : successMessage);
                        if (backAfterSuccess && data.success) {
                            return goBack();
                        }
                    };
                })(this)).error((function(_this) {
                    return function(data, status, headers, config) {
                        return _this.show(false, data != null ? data : errorMessage);
                    };
                })(this));
            }
        };
    }
    ])
    .controller('MainController', ["$scope", "$location", "$http", "AlertService",
        function ($scope, $location, $http, AlertService) {
            AlertService.init($scope);
            $http.get("/admin/info").success(function (data) {
                $scope.info = data;
            })
        }
    ]);
