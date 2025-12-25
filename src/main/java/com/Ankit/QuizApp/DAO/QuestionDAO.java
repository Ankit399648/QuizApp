package com.Ankit.QuizApp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ankit.QuizApp.Model.Questions;

@Repository
public interface QuestionDAO extends JpaRepository<Questions,Integer>{
	List<Questions> findByDifficulty(String diff);
}
