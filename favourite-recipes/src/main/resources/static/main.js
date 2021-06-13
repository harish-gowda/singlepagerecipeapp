var app = angular.module("Recipes", []);

// Controller Part
app.controller("RecipeController", function($scope, $http) {

	$scope.favRecipe = true;
	$scope.recipeDetails = false;
	$scope.recipeForm = false;


	$scope.recipes = [];
	$scope.recipe = {
		id: 1,
		recipename: "",
		recipetype: "",
		servings: "",
		ingredients: "",
		cookinginstructions: "",
		creationdate: "",
	};

	// Now load the data from server
	_refreshRecipeData();

	// HTTP POST/PUT methods for add/edit Recipe  
	// Call: http://localhost:8080/recipe
	$scope.submitRecipe = function() {

		var method = "";
		var url = "";

		if ($scope.recipe.id == -1) {
			method = "POST";
			url = '/recipe';
		} else {
			method = "PUT";
			url = '/recipe';
		}

		$scope.recipeForm = false;

		$http({
			method: method,
			url: url,
			data: angular.toJson($scope.recipe),
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(_success, _error);
	};

	$scope.createRecipe = function() {
		$scope.recipeDetails = false;
		$scope.recipeForm = true;
		_clearFormData();
	}

	// HTTP DELETE- delete recipe by Id
	// Call: http://localhost:8080/recipe/{id}
	$scope.deleteRecipe = function(recipe) {
		$scope.recipeDetails = false;
		$scope.recipeForm = false;
		$http({
			method: 'DELETE',
			url: '/recipe/' + recipe.id
		}).then(_success, _error);
	};



	$scope.listRecipeById = function(recipe) {
		$scope.recipeForm = false;
		$scope.recipeDetails = true;
		$scope.recipe.id = recipe.id;
		$scope.recipe.recipename = recipe.recipename;
		$scope.recipe.recipetype = recipe.recipetype;
		$scope.recipe.servings = recipe.servings;
		$scope.recipe.ingredients = recipe.ingredients;
		$scope.recipe.cookinginstructions = recipe.cookinginstructions;
		var date = new Date(recipe.creationdate);
		$scope.recipe.creationdate = date.getDate() + "-" + (date.getMonth() + 1) + "-"
			+ date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes();

	}

	// In case of edit
	$scope.editRecipe = function(recipe) {
		$scope.recipeDetails = false;
		$scope.recipeForm = true;
		$scope.recipe.id = recipe.id;
		$scope.recipe.recipename = recipe.recipename;
		$scope.recipe.recipetype = recipe.recipetype;
		$scope.recipe.servings = recipe.servings;
		$scope.recipe.ingredients = recipe.ingredients;
		$scope.recipe.cookinginstructions = recipe.cookinginstructions;
	};

	// Private Method  
	// HTTP GET- get all recipes collection
	// Call: http://localhost:8080/recipes
	function _refreshRecipeData() {
		$http({
			method: 'GET',
			url: '/recipes'
		}).then(
			function(res) { // success
				$scope.recipes = res.data;
			},
			function(res) { // error
				console.log("Error: " + res.status + " : " + res.data);
			}
		);
	}

	function _success(res) {
		_refreshRecipeData();
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
		$scope.recipe.id = -1;
		$scope.recipe.recipename = "";
		$scope.recipe.recipetype = "";
		$scope.recipe.servings = "";
		$scope.recipe.ingredients = "";
		$scope.recipe.cookinginstructions = "";
		$scope.recipe.creationdate = "";
	};
});