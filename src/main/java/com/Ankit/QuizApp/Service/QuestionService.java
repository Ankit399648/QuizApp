package com.Ankit.QuizApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ankit.QuizApp.DAO.QuestionDAO;
import com.Ankit.QuizApp.Model.Questions;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO questionDao;
	public List<Questions> getAllQuestion() {
		return questionDao.findAll();
	}
	public List<Questions> getQuestionsByDifficulty(String diff) {
		// TODO Auto-generated method stub
		return questionDao.findByDifficulty(diff);
	}
	public String addQuestion(Questions question) {
		questionDao.save(question);
		return "Success";
	}
	
}
