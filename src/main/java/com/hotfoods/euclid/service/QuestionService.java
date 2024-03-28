package com.hotfoods.euclid.service;

import com.hotfoods.euclid.entity.Question;

import java.util.List;

public interface QuestionService {

    public Question findById(String id);

    public List<Question> findAll();

    public Question save(Question question);

    public Question update(Question question);

    public boolean delete(String id);
}
