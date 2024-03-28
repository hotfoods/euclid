package com.hotfoods.euclid.service.impl;

import com.hotfoods.euclid.dao.QuestionDao;
import com.hotfoods.euclid.entity.Question;
import com.hotfoods.euclid.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Override
    public Question findById(String id) {
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
    public boolean delete(String id) {
        boolean res=true;
        try {
            questionDao.deleteById(id);
        }
        catch (Exception ex){
            res=false;
        }
        return false;
    }
}
