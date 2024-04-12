package com.hotfoods.euclid.service;

import com.hotfoods.euclid.entity.Subject;
import com.hotfoods.euclid.entity.Unit;

import java.util.List;

public interface UnitService {

    public Unit findById(Long id);
    public List<Unit> findAll();
    public Unit save(Unit unit);
    public Unit update(Unit unit);
    public boolean delete(Long id);
    List<Unit> findBySubject(Subject subject);
}
