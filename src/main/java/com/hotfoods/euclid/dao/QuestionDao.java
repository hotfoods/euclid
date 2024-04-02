package com.hotfoods.euclid.dao;
import com.hotfoods.euclid.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionDao extends JpaRepository<Question,Long> {
}
