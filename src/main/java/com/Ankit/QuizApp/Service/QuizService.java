package com.Ankit.QuizApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Ankit.QuizApp.DAO.QuestionDAO;
import com.Ankit.QuizApp.DAO.QuizDao;
import com.Ankit.QuizApp.Model.Questions;
import com.Ankit.QuizApp.Model.QuestionsWrapper;
import com.Ankit.QuizApp.Model.Quiz;
import com.Ankit.QuizApp.Model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	@Autowired
	QuestionDAO questionDao; 

	public ResponseEntity<String> createQuiz(int nQ, String diff, String title) {
		List<Questions> questions=questionDao.getRandomQuestionByDifficulty(diff, nQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionsWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Questions> questionsFromDB = quiz.get().getQuestions();
		List<QuestionsWrapper> questionsForUser = new ArrayList<>();
		
		for(Questions q: questionsFromDB) {
			QuestionsWrapper qw=new QuestionsWrapper(q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getTitle());
			questionsForUser.add(qw);
			
		}
		
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz = quizDao.findById(id).get();
		List<Questions> questions = quiz.getQuestions();
		int right = 0, i = 0;
		for(Response response : responses)
		{
			if(response.getResponse().equals(questions.get(i).getAnswer())) 
				right++;
			i++;
		}
		return new ResponseEntity<>(right, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<List<Quiz>> getAllQuizTitle() {
		List<Quiz> quizes=quizDao.findAll();
		return new ResponseEntity<>(quizes, HttpStatus.OK);
	}

	public ResponseEntity<String> deleteQuiz(Integer id) {
		quizDao.deleteById(id);
		return new ResponseEntity<>("deleted successfully", HttpStatus.ACCEPTED);
	}
}
