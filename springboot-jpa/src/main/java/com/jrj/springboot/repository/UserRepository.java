package com.jrj.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrj.springboot.entity.User;

//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {
}
