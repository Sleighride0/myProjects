package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.QuizDto;

import java.util.List;

public interface QuizDao {

    public List<QuizDto> getUserQuizzes(int userId);
}
