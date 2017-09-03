package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/9/2.
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}
