package com.example.demo1.Service;
import com.example.demo1.Repository.EducationRepository;
import com.example.demo1.Repository.ProfileRepository;
import com.example.demo1.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService {
    
    @Autowired
    EducationRepository educationRepository;
    @Autowired
    ProfileRepository profileRepository;


    public Education getEducation(Integer id) {
        return educationRepository.findById(id).get();
    }


    public Education createEducation(Integer id, Education education) {
        Education education1=educationRepository.save(education);
        Profile profile=profileRepository.findById(id).orElse(null);
        profile.getEducations().add(education1);
        profileRepository.save(profile);
        return education1;
    }

    public Education updateEducation(Integer id, Education education) {
        Education oldEducation=educationRepository.findById(id).orElse(null);
        if(oldEducation!=null){
            oldEducation.setSchool(education.getSchool());
            oldEducation.setLocation(education.getLocation());
            oldEducation.setDegree(education.getDegree());
            oldEducation.setGrade(education.getGrade());
            oldEducation.setField((education.getField()));
            oldEducation.setStartDate(education.getStartDate());
            oldEducation.setEndDate(education.getEndDate());
            return educationRepository.save(oldEducation);
        }
        return null;
    }

    public void deleteEducation(Integer id) {
        educationRepository.deleteById(id);
    }
}
