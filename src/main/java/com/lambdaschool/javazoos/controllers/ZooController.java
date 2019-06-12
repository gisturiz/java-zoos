package com.lambdaschool.javazoos.controllers;

import com.lambdaschool.javazoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZooController
{
    @Autowired
    private ZooService zooService;

    @GetMapping(value = "/zoos/zoos", produces = {"application/json"})
    public ResponseEntity<?> getCountAnimalsInZoos()
    {
        return new ResponseEntity<>(zooService.getCountAnimalsInZoos(), HttpStatus.OK);
    }

    @DeleteMapping("/admin/zoos/{zooid}")
    public ResponseEntity<?> deleteZooById(@PathVariable long zooid)
    {
        zooService.delete(zooid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
