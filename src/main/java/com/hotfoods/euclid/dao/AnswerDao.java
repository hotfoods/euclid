package com.hotfoods.euclid.dao;
import com.hotfoods.euclid.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerDao extends JpaRepository<Answer,Long> {
}
