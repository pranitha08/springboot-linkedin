package com.example.demo1.Controller;

import com.example.demo1.Service.ProfileService;
import com.example.demo1.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping(value = "/{id}")
    public Profile getProfile(@PathVariable Integer id) {
        return profileService.getProfile(id);
    }


    @PostMapping("/post/{id}")
    public Profile addProfile(@PathVariable Integer id,@RequestBody Profile profile) {
        return profileService.addProfile(id, profile);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Integer id) {
        profileService.deleteProfile(id);
    }

    @PutMapping("/put/{id}")
    public Profile UpdateProfile(@PathVariable Integer id,@RequestBody Profile profile) {
        return profileService.UpdateProfile(id, profile);
    }

}
