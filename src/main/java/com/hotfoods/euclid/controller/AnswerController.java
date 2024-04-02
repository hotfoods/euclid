package com.hotfoods.euclid.controller;

import com.hotfoods.euclid.entity.Answer;
import com.hotfoods.euclid.entity.Question;
import com.hotfoods.euclid.service.AnswerService;
import com.hotfoods.euclid.service.QuestionService;
import com.hotfoods.euclid.utils.TimeUtils;
import com.hotfoods.euclid.utils.UidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnswerController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/toaddan/{qid}")
    public String toAddAnPage(Model model,
                              @PathVariable String qid){
        System.out.println(qid);
        model.addAttribute("qid",qid);
        return "/ans/addans";
    }

    @PostMapping("/addans")
    public String addAns(@RequestParam("solution") String solution,
                         @RequestParam("qid") String qid){
        System.out.println(solution);
        Answer answer=new Answer();
        answer.setId(UidUtil.getInstance().nextId());
        answer.setCreatetime(TimeUtils.getSTRTimeSec());
        answer.setQuestion(questionService.findById(Long.valueOf(qid)));
        answer.setSolution(solution);

        try{
            answerService.save(answer);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("答案插入失败");
        }

        return "index";
    }

    @GetMapping("/toans/{qid}")
    public String toAns(@PathVariable String qid,
                        Model model){
        Question question=questionService.findById(Long.valueOf(qid));
        model.addAttribute("ans",question.getAns());
        return "ans/ans";
    }
}
