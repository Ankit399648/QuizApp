package com.Ankit.QuizApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ankit.QuizApp.Service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@GetMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam("noQ") int nQ, @RequestParam("difficulty") String diff){
		return new ResponseEntity<>("new Quiz created", HttpStatus.OK);
	}
}
