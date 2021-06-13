package com.demo.recipe.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

/**
 * 
 * @author Harish
 *
 */

@Entity
@Table(name="RECIPES")
public @Data class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column(length=255)
	private String recipename;

	@Column(length=255)
	private String recipetype;
	
	@Column
	private Integer servings;

	@Column
	@Lob
	private String ingredients;
	
	@Column
	@Lob
	private String cookinginstructions;

	@Column
	@CreationTimestamp
	private LocalDateTime creationdate;

}
