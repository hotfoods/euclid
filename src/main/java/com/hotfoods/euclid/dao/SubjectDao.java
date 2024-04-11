package com.hotfoods.euclid.dao;

import com.hotfoods.euclid.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDao extends JpaRepository<Subject,Long> {
}
