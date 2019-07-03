package com.jnshu.controller;

import com.jnshu.pojo.Company;
import com.jnshu.pojo.CompanyExample;
import com.jnshu.service.CompanyService;
import com.jnshu.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName CompanyController
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/22 3:40
 * @Version 1.0
 **/

@Controller
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/a/recommend", method = RequestMethod.GET)
    public ModelAndView toRecommend(@RequestParam(value = "id", defaultValue = "1") Long id, HttpServletRequest request) {
        CompanyExample example = new CompanyExample();
        CompanyExample.Criteria criteria = example.createCriteria();
        List<Company> list = companyService.selectByCompany(example);
//        System.out.println("=============================" + list.size() + "=============================");
        Company company = companyService.selectByPrimaryKey(id);
//        System.out.println(id);
        ModelAndView mav = new ModelAndView("company");
        String name = (null != CookieUtil.isLogin(request) ? CookieUtil.isLogin(request) : null);
        mav.addObject("name", name);
        mav.addObject("film", company);
        mav.addObject("list", list);
        return mav;
    }
}

