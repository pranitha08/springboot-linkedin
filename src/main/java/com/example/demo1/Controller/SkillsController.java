package com.example.demo1.Controller;

import com.example.demo1.Services.SkillsServices;
import com.example.demo1.entity.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skills")
public class SkillsController {
    @Autowired
    SkillsServices skillTypeServices;

    @GetMapping(value = "/{id}")
    public Skills getSkill(@PathVariable Integer id) {
        return skillTypeServices.getSkill(id);
    }

    @PostMapping("/post/{id}")
    public Skills createSkill(@PathVariable Integer id,@RequestBody Skills skillType){
        return skillTypeServices.createSkill(id,skillType);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Integer id) {
        skillTypeServices.deleteSkill(id);
    }
}
