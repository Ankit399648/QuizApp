package com.Ankit.QuizApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ankit.QuizApp.Model.QuestionsWrapper;
import com.Ankit.QuizApp.Model.Response;
import com.Ankit.QuizApp.Service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam("noQ") int nQ, @RequestParam("difficulty") String diff, @RequestParam("title") String title){
		return quizService.createQuiz(nQ, diff, title);
	}
	
	@GetMapping("getQuiz/{id}")
	public ResponseEntity<List<QuestionsWrapper>> getQuiz(@PathVariable("id") Integer id)
	{
		return quizService.getQuizQuestions(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable("id") Integer id, @RequestBody List<Response> responses){
		return quizService.calculateResult(id, responses);
	}
}
