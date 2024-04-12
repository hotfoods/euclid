package com.hotfoods.euclid.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Value {

    private Long id;
    private String uid;
    private String name;
    private List<Object> objs;
    private Object obj;
}
