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
<title>template.jsp</title>
<script type="text/javascript">
	var deps = ['ngRoute',
	            'ngAnimate',
	            'ngTouch',
	            'angular-loading-bar'
	           ];

	var app = angular.module("employeeApp", deps);
	
	app.controller("mainController", function($scope, $http) {
		console.log("mainController...");
		
		$scope.submit = function() {
			var ajax = $http.post("/Employee/user/login", {
				id : "hsseo",
				password : "1234"
			})
			ajax.then(function(value) {
				console.dir(value);
				location.href = "/Employee/city/main.html"
			}, function(reason) {
				console.dir(reason);
				//alert("fail...");
			})
			
		};
		
	});
	
</script>
</head>
<body data-ng-controller="mainController" class="container">
<h1 data-ng-click="login()">회원 로그인...</h1>

<div class="row">
    <div class="col-sm-4 col-sm-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Please Sign In</h3>
            </div>
            <div class="panel-body">
                <form role="form" novalidate="novalidate" data-ng-submit="submit()">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus>
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Password" name="password" type="password" value="">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="remember" type="checkbox" value="Remember Me">Remember Me
                            </label>
                        </div>
                        <!-- Change this to a button or input when using this as a form -->
                        <button  type="submit" class="btn btn-lg btn-success btn-block">Login</button>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>