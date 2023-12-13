package com.exam.bean;

import java.util.ArrayList;

public class Quiz 
{
	ArrayList<Question> questions;
    private int currentQuestionIndex;
    private int userScore;

    public Quiz(ArrayList<Question> questions) 
    {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.userScore = 0;
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    public boolean hasNextQuestion() {
        return currentQuestionIndex < questions.size();
    }

    public void nextQuestion() 
    {
        if (hasNextQuestion()) 
        {
            currentQuestionIndex++;
        }
    }

    public int getUserScore() {
        return userScore;
    }

    public void incrementUserScore() {
        userScore++;
    }
    
    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
