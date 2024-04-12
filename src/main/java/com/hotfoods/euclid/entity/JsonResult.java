package com.hotfoods.euclid.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class JsonResult {

    private Object obj;
    private String msg;
    private Integer code;

    public JsonResult(Object obj){
        this.obj=obj;
    }

    public JsonResult(Object obj,String msg){
        this.obj=obj;
        this.msg=msg;
    }

    public JsonResult(Object obj,String msg,Integer code){
        this.obj=obj;
        this.msg=msg;
        this.code=code;
    }
}
