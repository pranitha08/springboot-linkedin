package com.example.demo1.Service;

import com.example.demo1.Repository.ExperienceRepository;

import com.example.demo1.Repository.ProfileRepository;
import com.example.demo1.entity.Experience;
import com.example.demo1.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {

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
            oldExperience.setCompanyName(experience.getCompanyName());
            oldExperience.setLocation(experience.getLocation());
            oldExperience.setPosition(experience.getPosition());
            oldExperience.setStartDate(experience.getStartDate());
            oldExperience.setEndDate(experience.getEndDate());
            oldExperience.setDescription(experience.getDescription());
            return experienceRepository.save(oldExperience);
        }
        return null;
    }
}
