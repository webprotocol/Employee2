<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="ko" data-ng-app="employeeApp">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<%@ include file="/WEB-INF/view/common.jspf" %>
<title>login.jsp</title>
<c:url var="LOGIN_URL" value="/user/login"/>
<c:url var="LOGIN_SUCCESS_URL" value="/city/main.html"/>

<script type="text/javascript">
	var LOGIN_URL = "${LOGIN_URL}";
	var LOGIN_SUCCESS_URL = "${LOGIN_SUCCESS_URL}";
	
	var deps = ['ngRoute',
	            'ngAnimate',
	            'ngTouch',
	            'angular-loading-bar'
	           ];

	var app = angular.module("employeeApp", deps);
	
	app.controller("mainController", function($scope, $http, $location) {
		console.log("mainController...");
		console.log("LOGIN_URL = " + LOGIN_URL);
		
		$scope.submit = function() {
			console.log("login.. = " + LOGIN_URL);
			var ajax = $http.post(LOGIN_URL, {
				email : $scope.email,
				password : $scope.password,
				remember : $scope.remember
			});
			
			ajax.then(function(value) {
// 				alert("success...");
				location.href = "${LOGIN_SUCCESS_URL}";
			}, function(reason) {
// 				alert("fail...");
				console.dir(reason);
				$scope.email = "";
				$scope.password = "";
				$scope.error = reason.data;
			});
			
		};
		
	});
	
</script>
</head>
<body data-ng-controller="mainController" class="container">
<div class="row">
    <div class="col-sm-8 col-sm-offset-2">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Please Sign In</h3>
                <div data-ng-show="error">
                	{{error.message}}
                </div>
            </div>
            <div class="panel-body">
                <form name="loginForm" novalidate="novalidate" data-ng-submit="submit()">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" 
                            	   placeholder="E-mail" 
                            	   name="email" 
                            	   required="required"
                            	   type="email" autofocus
                            	   data-ng-model="email"
                            	   data-ng-change="error = null"
                            	   >
                        <div data-ng-show="loginForm.email.$dirty">
                        	<div data-ng-show="loginForm.email.$error.required">
                        		필수 입력 항목입니다.
                        	</div>
                        	<div data-ng-show="loginForm.email.$error.email">
                        		이메일 형식이 아닙니다.
                        	</div>
                        </div>    	   
                        </div>
                        
                        <div class="form-group">
                            <input class="form-control" 
                            	   placeholder="Password" 
                            	   name="password" 
                            	   type="password"
                            	   required="required"
                            	   data-ng-model="password"
                            	   data-ng-change="error = null"
                            	   >
	                        <div data-ng-show="loginForm.password.$dirty">
	                        	<div data-ng-show="loginForm.password.$error.required">
	                        		필수 입력 항목입니다.
	                        	</div>
	                        </div>    	   
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="remember" 
                                	   type="checkbox" 
                                	   data-ng-model="remember"
                                	   >Remember Me
                            </label>
                        </div>
                        <!-- Change this to a button or input when using this as a form -->
                        <button  data-ng-disabled="loginForm.$invalid" type="submit" class="btn btn-lg btn-success btn-block">Login</button>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>