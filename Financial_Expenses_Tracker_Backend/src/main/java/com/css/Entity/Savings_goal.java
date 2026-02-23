package com.css.Entity;

import java.security.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Savings_Goal")
public class Savings_goal {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Goal_Name")
	@com.fasterxml.jackson.annotation.JsonProperty("title")
	private String goal_name;

	@Column(name = "Subtitle")
	private String subtitle;

	@Column(name = "Target_Amount")
	@com.fasterxml.jackson.annotation.JsonProperty("targetAmount")
	private Double target_amount;

	@Column(name = "Saved_Amount")
	@com.fasterxml.jackson.annotation.JsonProperty("saved")
	private Double saved_amount;

	@Column(name = "Created_At")
	private LocalDateTime created_at;

	@Column(name = "Icon_Code")
	@com.fasterxml.jackson.annotation.JsonProperty("iconCode")
	private int iconCode;

	@Column(name = "Color_Value")
	@com.fasterxml.jackson.annotation.JsonProperty("colorValue")
	private int colorValue;

	@com.fasterxml.jackson.annotation.JsonProperty("progress")
	public double getProgress() {
		if (target_amount == null || target_amount == 0)
			return 0.0;
		return (saved_amount != null ? saved_amount : 0) / target_amount;
	}
}
