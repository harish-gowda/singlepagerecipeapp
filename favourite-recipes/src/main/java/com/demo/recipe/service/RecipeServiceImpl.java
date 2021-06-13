package com.demo.recipe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.recipe.entities.Recipe;
import com.demo.recipe.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	public List<Recipe> getAllRecipes() {
		return recipeRepository.findAll();
	}

	@Override
	public Recipe saveRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);

	}

	@Override
	public Recipe getRecipeById(long id) {
		Optional<Recipe> optional = recipeRepository.findById(id);
		Recipe recipe = null;
		if (optional.isPresent()) {
			recipe = optional.get();
		} else {
			throw new RuntimeException("Recipe not found for id :: " + id);
		}
		return recipe;
	}

	@Override
	public void deleteRecipeById(long id) {
		recipeRepository.deleteById(id);

	}

	@Override
	public Recipe updateRecipe(long id, Recipe recipe) {
		recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found for id :: " + id));
		return recipeRepository.save(recipe);
	}

}
