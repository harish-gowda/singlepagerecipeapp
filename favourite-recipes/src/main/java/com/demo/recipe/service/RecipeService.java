package com.demo.recipe.service;

import java.util.List;

import com.demo.recipe.entities.Recipe;

public interface RecipeService {
	List<Recipe> getAllRecipes();

	Recipe saveRecipe(Recipe recipe);

	Recipe getRecipeById(long id);

	void deleteRecipeById(long id);

	Recipe updateRecipe(long id, Recipe recipe);
}
