package com.hotfoods.euclid.dao;
import com.hotfoods.euclid.entity.Question;
import com.hotfoods.euclid.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question,Long> {
    List<Question> findByUnit(Unit unit);
}
