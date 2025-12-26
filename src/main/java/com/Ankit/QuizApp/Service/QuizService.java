package com.Ankit.QuizApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ankit.QuizApp.DAO.QuizDao;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
}
