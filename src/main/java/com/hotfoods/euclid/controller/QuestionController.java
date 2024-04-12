package com.hotfoods.euclid.controller;

import com.hotfoods.euclid.entity.Question;
import com.hotfoods.euclid.service.QuestionService;
import com.hotfoods.euclid.service.SubjectService;
import com.hotfoods.euclid.service.UnitService;
import com.hotfoods.euclid.utils.TimeUtils;
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
public class QuestionController {

    private Logger logger =LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuestionService questionService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private UnitService unitService;

    @GetMapping("toaddq")
    public String toAddqPage(Model model){
       model.addAttribute("subjects",subjectService.findAll());
       return "/q/addq";
    }


    @PostMapping("/addq")
    public String addQuestion(@RequestParam("topic") String topic,
                              @RequestParam("subject") String subject,
                              @RequestParam("unit") String unit){
        System.out.println(topic+"  "+subject+"  "+unit);

        //
        Question question=new Question();
        question.setId(UidUtil.getInstance().nextId());
        question.setTopic(topic);
        question.setSubjectq(subjectService.findById(Long.valueOf(subject.trim())));
        question.setUnit(unitService.findById(Long.valueOf(unit.trim())));
        question.setCreatetime(TimeUtils.getSTRTimeSec());
    //    logger.debug("写入时间：{},获取id：{} ", question.getCreatetime(), question.getId());
        logger.info("写入时间：{},获取id：{} ,题目内容：{}", question.getCreatetime(), question.getId(),question.getTopic());

        try {
            questionService.save(question);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("题目写入数据库失败");
        }
        return "index";
    }

    @GetMapping("/getqs")
    public String getQs(Model model){
        List<Question> qs=new ArrayList<>();
        try {
            qs=questionService.findAll();
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("获取题目失败");
        }
        model.addAttribute("qs",qs);
        return  "/q/qs";
    }

    @GetMapping("/toqbyunit/{unitid}")
    public String toQByUnit(@PathVariable String unitid,Model model){
        model.addAttribute("qs",questionService.findByUnit(unitService.findById(Long.valueOf(unitid))));
        return "/q/qs";
    }
}
