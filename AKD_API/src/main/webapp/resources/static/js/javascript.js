
var app = angular.module('myApp', []);
app.controller('firstCtrl', function($scope, $http){
//	$scope.emailFormat = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
	
	$scope.display = function(){
		$http({
			url:'/display/',
			method:'GET'			
		}).then(function(response){
			$scope.user=response.data;
		//	console.log($scope.user);
		}, function(response){

		});
	}
	$scope.display();

	$scope.insert = function(){		
		$http({
			url:'/insert',
			method:'POST',
			data:{
				'name': $scope.name,
				'gender': $scope.gender,
				'email':$scope.email
			}	
			
		}).then(function(response){
			$scope.display();
			//console.log(response.config.data);
		}, function(response){

		});		
	}

	$scope.setValueToInput = function(data){
		//console.log(data);
		$scope.id=data.p.id;
		$scope.name=data.p.name;
		$scope.gender=data.p.gender;
		$scope.email=data.p.email;
		
	
		
		$scope.showInsert=false;
		$scope.showUpdate=true;	
	}
	$scope.showInsertButton = function(){
		$scope.showInsert=true;
		$scope.showUpdate=false;
		$scope.id='';
		$scope.name='';
		$scope.gender='Male';
		$scope.email='';		
	}
	

	$scope.update=function(){
		$http({
			url:'/update',
			method:'POST',
			data:{
				'id':$scope.id,
				'name': $scope.name,
				'gender': $scope.gender,
				'email':$scope.email
			}			
		}).then(function(response){
			$scope.display();
			//console.log($scope.name);
			//console.log(response);
		}, function(response){

		});		
	}

	$scope.delete= function(mydel){
		//console.log(mydel);
		var id = mydel.p.id;
		$http({
			url:'/delete/'+id,
			method:'GET',
			
		}).then(function(response){
			$scope.display();
		}, function(response){

		});
	}

	$scope.getDelete= function(i){
		swal({   title: "Are you sure?",   
			text: "You will not be able to recover this imaginary file!",   
			type: "warning",   showCancelButton: true,   
			confirmButtonColor: "#DD6B55",   
			confirmButtonText: "Yes",   
			cancelButtonText: "Cancel",   
			closeOnConfirm: false,   closeOnCancel: false },
			function(isConfirm){   
			 	if (isConfirm) {     
			 		swal("Deleted!", "Your imaginary file has been deleted.", "success"); 
			 		$scope.delete(i);
			 	}
		 		else {     
		 			swal("Cancelled", "Your imaginary file is safe :)", "error");   
		 		} 
		 	});
	}

});
