package com.hotfoods.euclid.service;

import com.hotfoods.euclid.entity.Subject;

import java.util.List;

public interface SubjectService {

    public Subject findById(Long id);
    public List<Subject> findAll();
    public Subject save(Subject subject);
    public Subject update(Subject subject);
    public boolean delete(Long id);
}
