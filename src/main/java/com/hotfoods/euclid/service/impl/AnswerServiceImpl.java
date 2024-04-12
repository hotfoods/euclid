package com.hotfoods.euclid.service.impl;

import com.hotfoods.euclid.dao.AnswerDao;
import com.hotfoods.euclid.entity.Answer;
import com.hotfoods.euclid.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerDao answerDao;

    @Override
    public List<Answer> findAll() {
        return answerDao.findAll();
    }

    @Override
    public Answer findById(Long id) {
        return answerDao.getById(id);
    }

    @Override
    public Answer save(Answer answer) {
        return answerDao.save(answer);
    }

    @Override
    public Answer update(Answer answer) {
        return answerDao.save(answer);
    }

    @Override
    public boolean delete(Long id) {
        boolean res=true;
        try {
            answerDao.deleteById(id);
        }
        catch (Exception ex){
            res=false;
        }
        return res;
    }
}
