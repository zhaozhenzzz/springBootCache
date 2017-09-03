package com.example.demo;

/**
 * Created by Administrator on 2017/9/2.
 */
public interface DemoService {
    public  Person save(Person person);

    public  void remove(Long id);

    public  Person findOne(Person person);
}
