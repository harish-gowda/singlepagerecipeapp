package com.demo.recipe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.recipe.entities.Recipe;
import com.demo.recipe.service.RecipeService;

@RestController
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@RequestMapping(value = "/recipes", method = RequestMethod.GET)
	@ResponseBody
	public List<Recipe> getRecipes() {
		return recipeService.getAllRecipes();
	}

	@RequestMapping(value = "/recipe/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Recipe getRecipe(@PathVariable("id") Long id) {
		return recipeService.getRecipeById(id);
	}

	@RequestMapping(value = "/recipe", method = RequestMethod.POST)
	@ResponseBody
	public Recipe saveRecipe(@RequestBody Recipe recipe) {
		return recipeService.saveRecipe(recipe);
	}

	@RequestMapping(value = "/recipe", method = RequestMethod.PUT)
	@ResponseBody
	public Recipe updateRecipe(@RequestBody Recipe recipe) {
		return recipeService.updateRecipe(recipe.getId(),recipe);
	}

	@RequestMapping(value = "/recipe/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRecipe(@PathVariable(value = "id") long id) {
		recipeService.deleteRecipeById(id);
	}
}
