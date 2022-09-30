package com.example.demo1.Controller;

import com.example.demo1.Services.ExperienceServices;
import com.example.demo1.entity.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experience")
public class ExperienceController {
    @Autowired
    ExperienceServices experienceServices;

    @GetMapping(value = "get/{id}")
    public Experience getExperience(@PathVariable Integer id) {
        return experienceServices.getExperience(id);
    }

    @PostMapping("/post/{id}")
    public Experience createExperience(@PathVariable Integer id,@RequestBody Experience experience) {
        return experienceServices.createExperience(id,experience);
    }
    @PutMapping("put/{id}")
    public Experience updateExperience(@PathVariable Integer id, @RequestBody Experience experience) {
        return experienceServices.updateAddress(id,experience);
    }
    @DeleteMapping("/{id}")
    public void deleteExperience(@PathVariable Integer id) {
        experienceServices.deleteExperience(id);
    }

}
