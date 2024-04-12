package com.hotfoods.euclid.service.impl;

import com.hotfoods.euclid.dao.QuestionDao;
import com.hotfoods.euclid.entity.Question;
import com.hotfoods.euclid.entity.Unit;
import com.hotfoods.euclid.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Override
    public Question findById(Long id) {
        return questionDao.getById(id);
    }

    @Override
    public List<Question> findAll() {
        return questionDao.findAll();
    }

    @Override
    public Question save(Question question) {
        return questionDao.save(question);
    }

    @Override
    public Question update(Question question) {
        return questionDao.save(question);
    }

    @Override
    public boolean delete(Long id) {
        boolean res=true;
        try {
            questionDao.deleteById(id);
        }
        catch (Exception ex){
            res=false;
        }
        return res;
    }

    @Override
    public List<Question> findByUnit(Unit unit) {
        return questionDao.findByUnit(unit);
    }
}
