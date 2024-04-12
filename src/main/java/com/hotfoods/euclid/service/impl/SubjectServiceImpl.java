package com.hotfoods.euclid.service.impl;

import com.hotfoods.euclid.dao.SubjectDao;
import com.hotfoods.euclid.entity.Subject;
import com.hotfoods.euclid.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public Subject findById(Long id) {
        return subjectDao.getById(id);
    }

    @Override
    public List<Subject> findAll() {
        return subjectDao.findAll();
    }

    @Override
    public Subject save(Subject subject) {
        return subjectDao.save(subject);
    }

    @Override
    public Subject update(Subject subject) {
        return subjectDao.save(subject);
    }

    @Override
    public boolean delete(Long id) {
        boolean res=true;
        try {
            subjectDao.deleteById(id);
        }
        catch (Exception ex){
            res=false;
        }
        return res;
    }
}
