package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/2.
 */
@Service
public class DemoServiceImpl implements  DemoService {
    @Autowired
    PersonRepository personRepository;

    @Override
    @CachePut(value = "people",key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id,Key为"+p.getId()+"的数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {

        System.out.println("删除了id,Key为"+id+"的数据缓存");
        personRepository.delete(id);
    }

    @Override
    @Cacheable(value = "people",key = "#person.id")
    public Person findOne(Person person) {
        Person p = personRepository.findOne(person.getId());
        System.out.println("为id,Key为"+p.getId()+"的数据做了缓存");
        return p;
    }
}
