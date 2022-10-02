package com.example.demo1.Controller;
import com.example.demo1.Service.EducationService;
import com.example.demo1.entity.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/education")
public class EducationController {
    @Autowired
    EducationService educationService;
    @GetMapping(value = "/get/{id}")
    public Education getEducation(@PathVariable Integer id) {
        return educationService.getEducation(id);
    }

    @PostMapping("/post/{id}")
    public Education createEducation(@PathVariable Integer id,@RequestBody Education education) {
        return educationService.createEducation(id,education);
    }
    @PutMapping("/put/{id}")
    public Education updateEducation(@PathVariable Integer id, @RequestBody Education education) {
        return educationService.updateEducation(id,education);
    }
    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable Integer id) {
        educationService.deleteEducation(id);
    }

}
