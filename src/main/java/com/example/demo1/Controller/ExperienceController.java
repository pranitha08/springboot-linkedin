package com.example.demo1.Controller;

import com.example.demo1.Service.ExperienceService;
import com.example.demo1.entity.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experience")
public class ExperienceController {
    @Autowired
    ExperienceService experienceService;

    @GetMapping(value = "get/{id}")
    public Experience getExperience(@PathVariable Integer id) {
        return experienceService.getExperience(id);
    }

    @PostMapping("/post/{id}")
    public Experience createExperience(@PathVariable Integer id,@RequestBody Experience experience) {
        return experienceService.createExperience(id,experience);
    }
    @PutMapping("put/{id}")
    public Experience updateExperience(@PathVariable Integer id, @RequestBody Experience experience) {
        return experienceService.updateAddress(id,experience);
    }
    @DeleteMapping("/{id}")
    public void deleteExperience(@PathVariable Integer id) {
        experienceService.deleteExperience(id);
    }

}
