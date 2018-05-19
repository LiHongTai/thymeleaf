package com.roger.thymeleaf.controller;

import com.roger.thymeleaf.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private List<Emp> emps = new ArrayList<>();

    public IndexController() throws Exception{
        emps.add(new Emp(7782, "CLARK", "MANAGER", 7839, new SimpleDateFormat("yyyy-MM-dd").parse("1981-06-09"), 2450.00, null, 10, "ACCOUNTING"));
        emps.add(new Emp(7839, "KING", "PRESIDENT", null, new SimpleDateFormat("yyyy-MM-dd").parse("1981-11-17"), 5000.00, null, 10, "ACCOUNTING"));
        emps.add(new Emp(7934, "MILLER", "CLERK", 7782, new SimpleDateFormat("yyyy-MM-dd").parse("1982-01-23"), 1300.00, null, 10, "ACCOUNTING"));
        emps.add(new Emp(7369, "SMITH", "CLERK", 7902, new SimpleDateFormat("yyyy-MM-dd").parse("1980-12-17"), 800.00, null, 20, "RESEARCH"));
        emps.add(new Emp(7566, "JONES", "MANAGER", 7839, new SimpleDateFormat("yyyy-MM-dd").parse("1981-04-02"), 2975.00, null, 20, "RESEARCH"));
        emps.add(new Emp(7788, "SCOTT", "ANALYST", 7566, new SimpleDateFormat("yyyy-MM-dd").parse("1987-07-13"), 3000.00, null, 20, "RESEARCH"));
        emps.add(new Emp(7876, "ADAMS", "CLERK", 7788, new SimpleDateFormat("yyyy-MM-dd").parse("1987-07-13"), 1100.00, null, 20, "RESEARCH"));
        emps.add(new Emp(7902, "FORD", "ANALYST", 7566, new SimpleDateFormat("yyyy-MM-dd").parse("1981-12-03"), 3000.00, null, 20, "RESEARCH"));
        emps.add(new Emp(7521, "WARD", "SALESMAN", 7698, new SimpleDateFormat("yyyy-MM-dd").parse("1981-02-22"), 1250.00, 500.00d, 30, "SALES"));
        emps.add(new Emp(7654, "MARTIN", "SALESMAN", 7698, new SimpleDateFormat("yyyy-MM-dd").parse("1981-09-28"), 1250.00, 1400.00d, 30, "SALES"));
        emps.add(new Emp(7698, "BLAKE", "MANAGER", 7839, new SimpleDateFormat("yyyy-MM-dd").parse("1981-05-01"), 2850.00, null, 30, "SALES"));
        emps.add(new Emp(7844, "TURNER", "SALESMAN", 7698, new SimpleDateFormat("yyyy-MM-dd").parse("1981-09-08"), 1500.00, 0.00d, 30, "SALES"));
        emps.add(new Emp(7900, "JAMES", "CLERK", 7698, new SimpleDateFormat("yyyy-MM-dd").parse("1981-12-03"), 950.00, null, 30, "SALES"));
    }

    @RequestMapping("/")
    public ModelAndView index(String keyword){
        ModelAndView modelAndView = new ModelAndView("index");

        List<Emp> resultList = emps;
        if(keyword !=null && !keyword.trim().equals("")){
            resultList = new ArrayList<>();
            for (Emp emp:emps) {
                if(emp.getEname().toLowerCase().indexOf(keyword.toLowerCase()) != -1)
                    resultList.add(emp);
            }
        }

        modelAndView.addObject("emps",resultList);

        return modelAndView;
    }

}
