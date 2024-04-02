package com.hotfoods.euclid.service;

import com.hotfoods.euclid.dao.AnswerDao;
import com.hotfoods.euclid.entity.Answer;

import java.util.List;

public interface AnswerService {

    public List<Answer> findAll();
    public Answer findById(Long id);
    public Answer save(Answer answer);
    public Answer update(Answer answer);
    public boolean delete(Long id);
}
