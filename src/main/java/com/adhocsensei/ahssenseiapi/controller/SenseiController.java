package com.adhocsensei.ahssenseiapi.controller;

import com.adhocsensei.ahssenseiapi.dao.SenseiRepository;
import com.adhocsensei.ahssenseiapi.dto.Sensei;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SenseiController {

    @Autowired
    SenseiRepository repo;

    @GetMapping("/senseiCourse")
    public List<Sensei> getAllSenseiCourses(@RequestParam(required = false) Long userId,
                                            @RequestParam(required = false) Long courseId) {
        if (userId != null) {
            return repo.findByUserId(userId);
        } else if (courseId != null) {
            return repo.findByCourseId(courseId);
        } else
        return repo.findAll();
    }

    @GetMapping("/senseiCourse/senseiList/{id}")
    public List<Sensei> getAllSenseiCoursesBySenseiId(@PathVariable Long id) {
        return repo.findByUserId(id);
    }

    @GetMapping("/senseiCourse/{id}")
    public Optional<Sensei> getSenseiCourseById(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping("/senseiCourse")
    public Sensei createSenseiCourse(@RequestBody Sensei sensei) {
        return repo.save(sensei);
    }

    @PutMapping("/senseiCourse/{id}")
    public void updateSenseiCourseById(@PathVariable Long id, @RequestBody Sensei sensei) {
        Optional<Sensei> optionalSensei = repo.findById(id);
        if (optionalSensei.isPresent()) {
            sensei.setId(id);
            repo.save(sensei);
        }
//        catch error and have appropriate response
    }

    @DeleteMapping("/senseiCourse/{id}")
    public void deleteSenseiCourseById(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
