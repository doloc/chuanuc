var app = angular.module("EmployeeManagement", []);

// Controller Part
app.controller("EmployeeController", function($scope, $http) {

	$scope.employees = [];
	$scope.employeeForm = {
		id : 1,
		no : "",
		name : ""
	};

	// Now load the data from server
	_refreshEmployeeData();

	// HTTP POST/PUT methods for add/edit employee
	// Call: http://localhost:8080/employee
	$scope.submitEmployee = function() {

		var method = "";
		var url = "";

		if ($scope.employeeForm.id == null) {
			method = "POST";
			url = '/ChuanUcWebApp/employee';
		} else {
			method = "PUT";
			url = '/ChuanUcWebApp/employee';
		}

		$http({
			method : method,
			url : url,
			data : angular.toJson($scope.employeeForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(_success, _error);
	};

	$scope.createEmployee = function() {
		_clearFormData();
	}

	// HTTP DELETE- delete employee by Id
	// Call: http://localhost:8080/employee/{id}
	$scope.deleteEmployee = function(employee) {
		$http({
			method : 'DELETE',
			url : '/ChuanUcWebApp/employee/' + employee.id
		}).then(_success, _error);
	};

	// In case of edit
	$scope.editEmployee = function(employee) {
		$scope.employeeForm.id = employee.id;
		$scope.employeeForm.no = employee.no;
		$scope.employeeForm.name = employee.name;
	};

	// Private Method
	// HTTP GET- get all employees collection
	// Call: http://localhost:8080/employees
	function _refreshEmployeeData() {
		$http({
			method : 'GET',
			url : '/ChuanUcWebApp/employees'
		}).then(function(res) { // success
			$scope.employees = res.data;
		}, function(res) { // error
			console.log("Error: " + res.status + " : " + res.data);
		});
	}

	function _success(res) {
		_refreshEmployeeData();
		_clearFormData();
	}

	function _error(res) {
		var data = res.data;
		var status = res.status;
		var header = res.header;
		var config = res.config;
		alert("Error: " + status + ":" + data);
	}

	// Clear the form
	function _clearFormData() {
		$scope.employeeForm.id = null;
		$scope.employeeForm.no = "";
		$scope.employeeForm.name = ""
	}
	;
});