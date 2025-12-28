package com.Ankit.QuizApp.Model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	String title;
	
	@ManyToAny
	List<Questions> questions;
}
