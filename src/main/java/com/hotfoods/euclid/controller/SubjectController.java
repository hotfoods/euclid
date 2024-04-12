package com.hotfoods.euclid.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hotfoods.euclid.entity.JsonResult;
import com.hotfoods.euclid.entity.Subject;
import com.hotfoods.euclid.entity.Unit;
import com.hotfoods.euclid.entity.Value;
import com.hotfoods.euclid.service.SubjectService;
import com.hotfoods.euclid.utils.UidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SubjectController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/toaddsubject")
    private String toAddSubject(){
        return "/subject/addsubject";
    }

    @RequestMapping("/tosubject")
    private String toSubject(Model model){
        model.addAttribute("subjects",subjectService.findAll());
        return "/subject/subject";
    }

    @PostMapping("/addsubject")
    public String addSubject(@RequestParam("name") String name){
        Subject subject=new Subject();
        subject.setId(UidUtil.getInstance().nextId());
        subject.setName(name);
        try{
            subjectService.save(subject);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("科目添加入库失败");
        }
        return "/index";
    }

    @RequestMapping("/subject/units/{subjectid}")
    @ResponseBody
    public JsonResult getSubjectUnits(@PathVariable String subjectid){
       Subject subject=subjectService.findById(Long.valueOf(subjectid));
        List<Unit> us= subject.getUnits();
        if(us.isEmpty()){
            return new JsonResult(null,"没有数据");
        }

        List<Value> vs=new ArrayList<>();
        for(Unit u:us){
            System.out.println(u.toString());

            //FastJson + jpa 一对多会出现循环栈溢出情况，数据封装在value里
            System.out.println(u.getId()+" name：  "+u.getName());
            Value value=new Value();
            value.setUid(String.valueOf(u.getId()));
            value.setName(u.getName());
            vs.add(value);

        }

        //JSONArray array=JSONArray.parseArray(JSON.toJSONString(us, SerializerFeature.DisableCircularReferenceDetect));
        return new JsonResult(vs);
    }
}
