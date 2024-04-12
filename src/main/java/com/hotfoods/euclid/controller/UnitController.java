package com.hotfoods.euclid.controller;

import com.hotfoods.euclid.entity.Unit;
import com.hotfoods.euclid.service.SubjectService;
import com.hotfoods.euclid.service.UnitService;
import com.hotfoods.euclid.utils.UidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

@Controller
public class UnitController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UnitService unitService;

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/toaddunit")
    public String toAddUnit(Model model){
        model.addAttribute("subjects",subjectService.findAll());
        return "/unit/addunit";
    }

    @RequestMapping("/tounit/{subjectid}")
    public String toUnit(Model model, @PathVariable String subjectid){
        if (subjectid==null){
            model.addAttribute("units",unitService.findAll());
        }
        else {
            model.addAttribute("units",unitService.findBySubject(subjectService.findById(Long.valueOf(subjectid))));
        }
        return "/unit/unit";
    }

    @RequestMapping("/addunit")
    public String addUnit(Model model,
                          @RequestParam("name") String name,
                          @RequestParam("subjectid") String subjectid){
        Unit unit=new Unit();
        unit.setName(name);
        unit.setSubject(subjectService.findById(Long.valueOf(subjectid)));
        unit.setId(UidUtil.getInstance().nextId());
        try {
            unitService.save(unit);
        }catch (Exception e){
            logger.error("单元添加入库失败");
        }
        return "/index";
    }
}
