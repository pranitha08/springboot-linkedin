package com.example.demo1.Controller;

import com.example.demo1.Services.ProfileServices;
import com.example.demo1.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileServices profileServices;

    @GetMapping(value = "/{id}")
    public Profile getProfile(@PathVariable Integer id) {
        return profileServices.getProfile(id);
    }


    @PostMapping("/post/{id}")
    public Profile addProfile(@PathVariable Integer id,@RequestBody Profile profile) {
        return profileServices.addProfile(id, profile);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Integer id) {
        profileServices.deleteProfile(id);
    }

    @PutMapping("/put/{id}")
    public Profile UpdateProfile(@PathVariable Integer id,@RequestBody Profile profile) {
        return profileServices.UpdateProfile(id, profile);
    }

}
