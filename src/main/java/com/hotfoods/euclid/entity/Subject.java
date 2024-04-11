package com.hotfoods.euclid.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "subject" ,cascade = CascadeType.ALL) // 什么时候用什么时候加载
    //	关联列 name外键列 referencedColumnName主表里的id
    private List<Unit> units;

    @OneToMany(mappedBy = "subjectq" ,cascade = CascadeType.ALL) // 什么时候用什么时候加载
    //	关联列 name外键列 referencedColumnName主表里的id
    private List<Question> questions;

}
