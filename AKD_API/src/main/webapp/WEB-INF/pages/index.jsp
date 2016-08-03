<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/style.css"/>

<meta charset="UTF-8">

 <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>    
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.6/angular.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert-dev.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
</head>
<body ng-app="myApp">
	<div class="container">
		<div ng-controller="firstCtrl">
			<div id="data">
				<div id="modal">
					<button type="button" id="btn-add" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" ng-click="showInsertButton()">Add New User</button>

					  <!-- Modal -->
					 <div class="modal fade" id="myModal" role="dialog">
					    <div class="modal-dialog">
					    
					      <!-- Modal content-->
					      <div class="modal-content">

					        <div class="modal-header">
					          <button type="button" class="close" data-dismiss="modal">&times;</button>
					          <h4 class="modal-title">Operation</h4>
					        </div>

					        <div class="modal-body">		        	
								<form role="form">
								    <div class="form-group">
								      <label>Name:</label>
								      <input type="text" class="form-control" placeholder="Name" ng-model="name"​ ng-pattern="/[^0-9]/">
								    </div>

								    <div class="form-group">
								      <label>Gender:</label>
								      
								        <select class="form-control" ng-model="gender">
					                        <option value="Male">Male</option>
					                        <option value="Female">Female</option>
				                    	</select>
                    					
								    <!--   <input type="text" class="form-control" placeholder="Gender" ng-model="gender" ng-pattern="genderFormat"> -->
								    </div>
								    
								    <div class="form-group">
								      <label>Email:</label>
								      <input type="text" class="form-control" placeholder="Email" ng-model="email" ng-pattern="emailFormat" >
								    </div>
							  	</form>       					
					        </div>

					        <div class="modal-footer">
								<input type="submit" ng-show="showInsert" name="submit" class="btn btn-primary" data-dismiss="modal" value="Insert" ng-click="insert()" ng-disabled="!name || !gender || !email">
								
								<input type="submit" ng-show="showUpdate" name="submit" class="btn btn-success" data-dismiss="modal" value="Update" ng-click="update()" ng-disabled="!name || !gender || !email">
					        </div>

					      </div>		      
					    </div>
					</div>
				</div>
				
				<div id="table">
					<table>
						<tr>
						    <th>ID</th>
						    <th>Name</th>
						    <th>Gender</th>
						    <th>Email</th>
						    <th>Action</th>    
						</tr>
						<tr ng-repeat="p in user | limitTo:10">
						    <td>{{p.id}}</td>
							<td>{{p.name}}</td>
							<td>{{p.gender}}</td>
							<td>{{p.email}}</td>
							<td>  <button class="btn btn-primary" ng-click="setValueToInput(this)" data-toggle="modal" data-target="#myModal">Edit</button> <button class="btn btn-danger" ng-click="getDelete(this)">Delete</button>   </td>
						</tr>
					</table>
				</div>
			</div>
		</div>	
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/javascript.js"></script>
</body>
</html>