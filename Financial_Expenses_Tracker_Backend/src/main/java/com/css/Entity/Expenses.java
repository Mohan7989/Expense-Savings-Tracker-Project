package com.css.Entity;

import java.security.Timestamp;
import java.time.LocalDate;

import jakarta.persistence.Id;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Expenses")
public class Expenses {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Amount")
	private Double amount;

	@Column(name = "Category")
	private String category;

	@Column(name = "ExpenseDate")
	@com.fasterxml.jackson.annotation.JsonProperty("date")
	private LocalDate expenseDate;

	@Column(name = "Description")
	private String description;

	@Column(name = "Created_at")
	@com.fasterxml.jackson.annotation.JsonProperty("time")
	private String created_at; // Changed to String to match Frontend 'time'

	@Column(name = "Icon")
	private String icon;
}
