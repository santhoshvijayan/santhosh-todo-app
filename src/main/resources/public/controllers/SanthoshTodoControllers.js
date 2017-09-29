app.controller('AddTasksController', function($scope , $location, DataTasksFactory, AddTasksFactory, $route ){
	$scope.now = new Date();
	$scope.now.setMinutes($scope.now.getMinutes() + 10);
	this.addTask = function(addNewTaskCtrl){
		AddTasksFactory.save(addNewTaskCtrl);
		DataTasksFactory.addTask(addNewTaskCtrl);
		
		window.setTimeout(function() {
			$location.path('/');
        }, 50); 
		
	};
});

app.controller('EditTasksController', function($scope, $location, ListTasksByIdFactory, EditTasksFactory, $route, $routeParams ){
	var selectedTask = ListTasksByIdFactory.query({id:$routeParams.id});
	selectedTask.$promise.then(function(result){
		$scope.editTaskCtrl = $scope.editTaskCtrl || {};
		$scope.editTaskCtrl.taskname = result.taskname;
		$scope.editTaskCtrl.performdate = new Date(result.performdate);
		$scope.editTaskCtrl.category = result.category;
		$scope.editTaskCtrl.priority = result.priority;
		$scope.editTaskCtrl.isdone = result.isdone;
	});
	
	this.editTask = function(editTaskCtrl){
		EditTasksFactory.update({id:$routeParams.id},editTaskCtrl);
		
		window.setTimeout(function() {
			$location.path('/');
        }, 10); 
		
	};
});
	
app.controller('ListTasksController', function($scope, $location,  DataTasksFactory, ListTasksFactory, $route){
	var task = ListTasksFactory.query();
	task.$promise.then(function (result) {
		DataTasksFactory.init(result);
	    $scope.tasks = DataTasksFactory.getTasks();
	});
});

app.controller('TasksPrioritiesListController', function($scope, TasksPrioritiesListFactory) {
	$scope.items = TasksPrioritiesListFactory.query();
});

app.controller('TasksActionsController', function($scope, $location, ListTasksByIdFactory, EditTasksFactory, DeleteTasksFactory) {
    
    $scope.checkTask = function(taskid) {
    	var selectedTask = ListTasksByIdFactory.query({id:taskid});
    	selectedTask.$promise.then(function(result){
    		result.isdone = "true";
    		EditTasksFactory.update({id:taskid},result);
    		
    		window.setTimeout(function() {
    			location.reload(true);
            }, 10);
    		
    	});
     };
    $scope.deleteTask = function(taskid) {
        DeleteTasksFactory.delete_task({id:taskid},null);
        
		window.setTimeout(function() {
			location.reload(true);
        }, 10);
		
     };
});
    