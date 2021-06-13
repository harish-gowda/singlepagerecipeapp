package com.demo.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.recipe.entities.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}