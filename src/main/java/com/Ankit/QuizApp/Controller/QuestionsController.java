package com.Ankit.QuizApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ankit.QuizApp.Model.Questions;
import com.Ankit.QuizApp.Service.QuestionService;

@RestController
@RequestMapping("questions")
public class QuestionsController 
{
	@Autowired
	QuestionService questionService;
	@GetMapping("allQuestions")
	public ResponseEntity<List<Questions>> getAllQuestions()
	{
		return questionService.getAllQuestion();
	}
	
	@GetMapping("difficulty/{diff}")
	public ResponseEntity<List<Questions>> getQuestionsByDifficulty(@PathVariable("diff") String diff)
	{
		return questionService.getQuestionsByDifficulty(diff);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Questions question) {
		return questionService.addQuestion(question);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable("id") int id) {
		return questionService.delete(id);
	}
}
