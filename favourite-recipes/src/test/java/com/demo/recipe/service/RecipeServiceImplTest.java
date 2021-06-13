package com.demo.recipe.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.demo.recipe.entities.Recipe;
import com.demo.recipe.repository.RecipeRepository;

/**
 * @author Harish
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceImplTest {

	@Mock
	private RecipeRepository recipeRepository;

	@InjectMocks
	private RecipeServiceImpl recipeService;

	/**
	 * Test method for
	 * {@link com.demo.recipe.service.RecipeServiceImpl#getAllRecipes()}.
	 */
	@Test
	public void testGetAllRecipes() {
		List<Recipe> recipes = new ArrayList<>();
		recipes.add(new Recipe());

		given(recipeRepository.findAll()).willReturn(recipes);

		List<Recipe> expected = recipeService.getAllRecipes();

		assertEquals(expected, recipes);
		verify(recipeRepository).findAll();
	}

	/**
	 * Test method for
	 * {@link com.demo.recipe.service.RecipeServiceImpl#saveRecipe(com.demo.recipe.entities.Recipe)}.
	 */
	@Test
	public void testSaveRecipe() {
		Recipe recipe = new Recipe();
		recipe.setRecipename("Test");
		recipe.setId(1L);
		when(recipeRepository.save(ArgumentMatchers.any(Recipe.class))).thenReturn(recipe);
		Recipe created = recipeService.saveRecipe(recipe);
		assertThat(created.getRecipename()).isSameAs(recipe.getRecipename());
		verify(recipeRepository).save(recipe);
	}

	/**
	 * Test method for
	 * {@link com.demo.recipe.service.RecipeServiceImpl#getRecipeById(long)}.
	 */
	@Test
	public void testGetRecipeById() {
		Recipe recipe = new Recipe();
		recipe.setRecipename("Test");
		recipe.setId(1L);

		when(recipeRepository.findById(recipe.getId())).thenReturn(Optional.of(recipe));

		Recipe expected = recipeService.getRecipeById(recipe.getId());

		assertThat(expected).isSameAs(recipe);
		verify(recipeRepository).findById(recipe.getId());
	}

	/**
	 * Test method for
	 * {@link com.demo.recipe.service.RecipeServiceImpl#deleteRecipeById(long)}.
	 */
	@Test
	public void testDeleteRecipeById() {
		Recipe recipe = new Recipe();
		recipe.setRecipename("Test");
		recipe.setId(1L);
		recipeService.deleteRecipeById(recipe.getId());
		verify(recipeRepository).deleteById(recipe.getId());
	}

	/**
	 * Test method for
	 * {@link com.demo.recipe.service.RecipeServiceImpl#updateRecipe(long, com.demo.recipe.entities.Recipe)}.
	 */
	@Test
	public void testUpdateRecipe() {
		Recipe recipe = new Recipe();
		recipe.setRecipename("Test");
		recipe.setId(1L);
		Recipe newrecipe = new Recipe();
		newrecipe.setRecipename("Test GG");
		given(recipeRepository.findById(recipe.getId())).willReturn(Optional.of(recipe));
		recipeService.updateRecipe(recipe.getId(), newrecipe);
		verify(recipeRepository).save(newrecipe);
		verify(recipeRepository).findById(recipe.getId());
	}

	@Test(expected = RuntimeException.class)
	public void testDeleteRecipeById_notFound() {
		Recipe recipe = new Recipe();
		recipe.setRecipename("Test");
		recipe.setId(1L);
		when(recipeRepository.findById(23L).orElseThrow());
		recipeRepository.deleteById(recipe.getId());
	}

}
