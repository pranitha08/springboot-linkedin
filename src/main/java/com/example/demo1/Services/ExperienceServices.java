package com.example.demo1.Services;

import com.example.demo1.Repository.ExperienceRepository;

import com.example.demo1.Repository.ProfileRepository;
import com.example.demo1.entity.Experience;
import com.example.demo1.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceServices {

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    ProfileRepository profileRepository;


    public Experience getExperience(Integer id) {
        return  experienceRepository.findById(id).get();

    }

    public Experience createExperience(Integer id,Experience experience) {
        Experience experience1=experienceRepository.save(experience);
        Profile profile=profileRepository.findById(id).orElse(null);
        profile.getExperiences().add(experience1);
        profileRepository.save(profile);
        return experience1;
    }

    public void deleteExperience(Integer id) {
        experienceRepository.deleteById(id);
    }

    public Experience updateAddress(Integer id, Experience experience) {
        Experience oldExperience=experienceRepository.findById(id).orElse(null);
        if(oldExperience!=null){
            oldExperience.setCompany_name(experience.getCompany_name());
            oldExperience.setLocation(experience.getLocation());
            oldExperience.setPosition(experience.getPosition());
            oldExperience.setStart_date(experience.getStart_date());
            oldExperience.setEnd_date(experience.getEnd_date());
            oldExperience.setDescription(experience.getDescription());
            return experienceRepository.save(oldExperience);
        }
        return null;
    }
}
