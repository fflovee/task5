package com.jnshu.controller;

import com.jnshu.pojo.JobExample;
import com.jnshu.service.JobService;
import com.jnshu.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName JobController
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/22 3:42
 * @Version 1.0
 **/

@Controller
public class JobController {

    @Autowired
    JobService jobService;

    @RequestMapping(value = "/a/job", method = RequestMethod.GET)
    public ModelAndView jobList(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("job");
        String name = (null != CookieUtil.isLogin(request) ? CookieUtil.isLogin(request) : null);
        mav.addObject("name", name);

        JobExample job1 = new JobExample();
        JobExample.Criteria c1 = job1.createCriteria();
        c1.andDirectionEqualTo("java前端工程师");
        List<JobExample> front = jobService.selectJobExample(job1);
        /*for (int i = 0; i < front.size(); i++) {
            System.out.println(front.get(i));
        }*/
        mav.addObject("front", front);

        JobExample job2 = new JobExample();
        JobExample.Criteria c2 = job2.createCriteria();
        c2.andDirectionEqualTo("Web前端工程师");
        List<JobExample> behind = jobService.selectJobExample(job2);
        mav.addObject("behind", behind);

        JobExample job3 = new JobExample();
        JobExample.Criteria c3 = job1.createCriteria();
        c3.andDirectionEqualTo("java前端工程师");
        List<JobExample> latter = jobService.selectJobExample(job3);
        mav.addObject("latter", latter);

        return mav;
    }
}
