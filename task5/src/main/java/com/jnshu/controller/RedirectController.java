package com.jnshu.controller;

import com.jnshu.pojo.Job;
import com.jnshu.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@ClassName JobController
 *@Description TODO
 *@Author 59200
 *@Date 2019/6/20 22:18
 *@Version 1.0
 **/

@Controller
public class RedirectController {

/*    @RequestMapping(value = "/excellence", method = RequestMethod.GET)
    public String toCompany(Model model) {
        model.addAttribute("sss","sss");
        return "excellence";
    }

    @RequestMapping(value = "/job",method = RequestMethod.GET)
    public String toJob(Model model) {
        model.addAttribute("qqq","qqq");
        return "job";
    }

    @RequestMapping(value = "/company",method = RequestMethod.GET)
    public String toRecommend(Model model) {
        model.addAttribute("qqq","qqq");
        return "company";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(Model model) {
        model.addAttribute("qqq","qqq");
        return "login";
    }*/

/*    @RequestMapping(value = "/a/register",method = RequestMethod.GET)
    public String toRegister() {
        return "register";
    }*/

/*    @RequestMapping(value = "/a/u/vip",method = RequestMethod.GET)
    public String toVip() {
        return "vip";
    }*/
}