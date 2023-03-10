package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Child;
import com.example.demo.service.ApiService;

@RestController
public class ApiController {
    @Autowired
    private ApiService apis;

    @GetMapping
    public ResponseEntity<List<Child>> getAllFuels(@RequestParam(required = false) String sortBy) {
        Sort sort = null;
        if (sortBy != null) {
            sort = Sort.by(sortBy);
        }
        List<Child> fuels = apis.getAllFuels(sort);
        return new ResponseEntity<>(fuels, HttpStatus.OK);
    }
    
    @GetMapping("/get")
    public List<Child> getAllFuels() {
        return apis.getAllFuels();
    }
    
    @GetMapping("get/{page}/{no}")
	public Page<Child> pagination(@PathVariable("page") int page,@PathVariable("no") int no){
		return apis.showValues(page,no);
	}
    

    @PostMapping("/add")
    public Child createFuel(@RequestBody Child childd) {
        return apis.createFuel(childd);
    }

}
