package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/9/3.
 */
@RestController
public class CacheController {
    @Autowired
    DemoService demoService;
    @RequestMapping("/put")
    public Person put(Person person){
        return  demoService.save(person);
    }
    @RequestMapping("/able")
    public Person cacheable(Person person){
        return  demoService.findOne(person);
    }

    @RequestMapping("/evict")
    public String evict(Long id){
          demoService.remove(id);
        return  "OK";
    }
}
