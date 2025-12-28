package com.Ankit.QuizApp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Ankit.QuizApp.Model.Questions;

@Repository
public interface QuestionDAO extends JpaRepository<Questions,Integer>{
	List<Questions> findByDifficulty(String diff);

	@Query(value="SELECT * FROM questions q Where difficulty = :diff ORDER BY RANDOM() LIMIT :nQ", nativeQuery = true)
	List<Questions> getRandomQuestionByDifficulty(String diff, int nQ);
}
