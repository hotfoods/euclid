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
@Table(name = "unit")
public class Unit {
    
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "subjectid")
    private Subject subject;

    @OneToMany(mappedBy = "unit" ,cascade = CascadeType.ALL) // 什么时候用什么时候加载
    //	关联列 name外键列 referencedColumnName主表里的id
    private List<Question>  questions;

}
