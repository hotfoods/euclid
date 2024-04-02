package com.hotfoods.euclid.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String solution;

    @Column
    private String createtime;

    @ManyToOne
    @JoinColumn(name = "q_id")
    private Question question;

}
