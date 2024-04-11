package com.hotfoods.euclid.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "q_no")
    private String qno;

    @Column(name = "topic")
    private String topic;

    @Column(name = "views")
    private Long views;

    @Column(name = "type")
    private String type;

    @Column(name="createtime")
    private String createtime;

    @OneToMany(mappedBy = "question" ,cascade = CascadeType.ALL) // 什么时候用什么时候加载
    //	关联列 name外键列 referencedColumnName主表里的id
    private List<Answer> ans;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "subjectid_q")
    private Subject subjectq;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Question question = (Question) o;
        return id != null && Objects.equals(id, question.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
