package com.Ankit.QuizApp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Ankit.QuizApp.DAO.QuestionDAO;
import com.Ankit.QuizApp.Model.Questions;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO questionDao;
	
	public ResponseEntity<List<Questions>> getAllQuestion() {
		try {			
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	
	public ResponseEntity<List<Questions>> getQuestionsByDifficulty(String diff) {
		try {			
			return new ResponseEntity<>(questionDao.findByDifficulty(diff), HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	
	public ResponseEntity<String> addQuestion(Questions question) {
		try {			
			questionDao.save(question);
			return new ResponseEntity<>("Success", HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failure", HttpStatus.NOT_IMPLEMENTED);
	}
	
	
	public ResponseEntity<String> delete(int id) {
		try {			
			questionDao.deleteById(id);
			return new ResponseEntity<>("Deletion Succesfull", HttpStatus.ACCEPTED);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failure", HttpStatus.NOT_IMPLEMENTED);
	}
	
}
