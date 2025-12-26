package com.Ankit.QuizApp.Model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Quiz {

	@Id
	Integer id;
	String title;
	
	@ManyToAny
	List<Questions> questions;
}
