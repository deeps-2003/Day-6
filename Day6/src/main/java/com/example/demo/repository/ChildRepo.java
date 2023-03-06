package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Child;

public interface ChildRepo extends JpaRepository<Child,Integer> {

}
