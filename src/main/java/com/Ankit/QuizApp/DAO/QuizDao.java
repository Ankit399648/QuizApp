package com.Ankit.QuizApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ankit.QuizApp.Model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{
	
}
