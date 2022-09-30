package com.example.demo1.Services;
import com.example.demo1.Repository.ProfileRepository;
import com.example.demo1.Repository.SkillsRepository;
import com.example.demo1.entity.Profile;
import com.example.demo1.entity.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SkillsServices {
    @Autowired
    SkillsRepository skillsRepository;
    @Autowired
    ProfileRepository profileRepository;

    public Skills createSkill(Integer id,Skills skill) {
        Skills skill1=skillsRepository.save(skill);
        Profile profile=profileRepository.findById(id).orElse(null);
        profile.getSkills().add(skill1);
        profileRepository.save(profile);
        return skill1;
    }

    public Skills getSkill(Integer id) {
        return skillsRepository.findById(id).get();
    }

    public void deleteSkill(Integer id) {
        skillsRepository.deleteById(id);
    }
}
