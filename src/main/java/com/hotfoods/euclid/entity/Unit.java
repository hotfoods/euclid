package com.hotfoods.euclid.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "unit")
public class Unit {
    
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
    @JoinColumn(name = "subjectid")
    private Subject subject;

    @OneToMany(mappedBy = "unit" ,cascade = CascadeType.ALL) // 什么时候用什么时候加载
    //	关联列 name外键列 referencedColumnName主表里的id
    private List<Question>  questions;

}
