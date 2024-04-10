package com.hotfoods.euclid.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


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

}
