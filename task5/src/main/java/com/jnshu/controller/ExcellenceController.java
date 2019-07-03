package com.jnshu.controller;

import com.jnshu.pojo.Excellence;
import com.jnshu.pojo.ExcellenceExample;
import com.jnshu.service.ExcellenceService;
import com.jnshu.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName ExcellenceController
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/22 3:41
 * @Version 1.0
 **/

@Controller
public class ExcellenceController {

    @Autowired
    ExcellenceService excellenceService;

    @RequestMapping(value = "/a/excellence", method = RequestMethod.GET)
    public ModelAndView selectExcellence(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("excellence");
        String name = (null != CookieUtil.isLogin(request) ? CookieUtil.isLogin(request) : null);
        mav.addObject("name", name);
        ExcellenceExample example = new ExcellenceExample();
        example.setOrderByClause("salary desc");
//        ExcellenceExample.Criteria criteria = example.createCriteria();
        List<Excellence> list = excellenceService.selectExcellenceExample(example);
        List<Excellence> array;
        if (list.size() > 5) {
            array = list.subList(0, 4);
        } else {
            array = list;
        }
        mav.addObject("list", array);
        return mav;
    }

}
