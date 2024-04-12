package com.hotfoods.euclid.service.impl;

import com.hotfoods.euclid.dao.UnitDao;
import com.hotfoods.euclid.entity.Subject;
import com.hotfoods.euclid.entity.Unit;
import com.hotfoods.euclid.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitDao unitDao;

    @Override
    public Unit findById(Long id) {
        return unitDao.getById(id);
    }

    @Override
    public List<Unit> findAll() {
        return unitDao.findAll();
    }

    @Override
    public Unit save(Unit unit) {
        return unitDao.save(unit);
    }

    @Override
    public Unit update(Unit unit) {
        return unitDao.save(unit);
    }

    @Override
    public boolean delete(Long id) {
        boolean res=true;
        try{
            unitDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            res=false;
        }
        return res;
    }

    @Override
    public List<Unit> findBySubject(Subject subject) {
        return unitDao.findBySubject(subject);
    }
}
