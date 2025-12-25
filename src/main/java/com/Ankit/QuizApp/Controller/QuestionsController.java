package com.Ankit.QuizApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Questions> getAllQuestions()
	{
		return questionService.getAllQuestion();
	}
	
	@GetMapping("difficulty/{diff}")
	public List<Questions> getQuestionsByDifficulty(@PathVariable("diff") String diff)
	{
		return questionService.getQuestionsByDifficulty(diff);
	}
	
	@PostMapping("add")
	public String addQuestion(@RequestBody Questions question) {
		return questionService.addQuestion(question);
	}
}
