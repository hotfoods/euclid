package com.hotfoods.euclid.controller;

import com.hotfoods.euclid.entity.Question;
import com.hotfoods.euclid.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("toaddq")
    public String toAddqPage(){
       return "/q/addq";
    }


    @PostMapping("/addq")
    public String addQuestion(@RequestParam("topic") String topic){
        System.out.println(topic);
        Question question=new Question();
        question.setTopic(topic);
        question.toString();
        return "index";
    }
}
