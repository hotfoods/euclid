package com.hotfoods.euclid.dao;

import com.hotfoods.euclid.entity.Subject;
import com.hotfoods.euclid.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectDao extends JpaRepository<Subject,Long> {
}
