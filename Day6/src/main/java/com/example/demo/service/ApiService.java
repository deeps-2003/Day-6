package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.models.Child;
import com.example.demo.repository.ChildRepo;

@Service
public class ApiService {
    @Autowired
    ChildRepo cr;

    public List<Child> getAllFuels() {
        return cr.findAll();
    }
    
    public List<Child> getAllFuels(Sort sort) {
        return cr.findAll(sort);
    }

    

    public Child createFuel(Child childd) {
        return cr.save(childd);
    }

    public Page<Child> showValues(int page,int no)
    {
    	Pageable p = PageRequest.of(page,no);
    	
    	return cr.findAll(p);
    }
	
}
