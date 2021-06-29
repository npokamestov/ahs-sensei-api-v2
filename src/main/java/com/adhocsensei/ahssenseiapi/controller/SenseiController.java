package com.adhocsensei.ahssenseiapi.controller;

import com.adhocsensei.ahssenseiapi.dao.SenseiRepository;
import com.adhocsensei.ahssenseiapi.dto.Sensei;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SenseiController {

    @Autowired
    SenseiRepository repo;

    @GetMapping("/senseiCourse")
    public List<Sensei> getAllSenseiCourses() {
        return repo.findAll();
    }

    @GetMapping("/senseiCourse/{id}")
    public Sensei getASenseiCourse(@PathVariable Long id) {
        return repo.getById(id);
    }

    @PostMapping("/senseiCourse")
    public Sensei createASenseiCourse(@RequestBody Sensei sensei) {
        return repo.save(sensei);
    }

    @PutMapping("/senseiCourse/{id}")
    public void updateASenseiCourse(@PathVariable Long id, @RequestBody Sensei sensei) {
        sensei.setId(id);
        repo.save(sensei);
    }

    @DeleteMapping("/senseiCourse/{id}")
    public void deleteASenseiCourse(@PathVariable Long id) {
        repo.deleteById(id);
    }

}
