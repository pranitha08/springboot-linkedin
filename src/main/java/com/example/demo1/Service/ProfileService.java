package com.example.demo1.Service;
import com.example.demo1.Repository.LoginRepository;
import com.example.demo1.Repository.ProfileRepository;
import com.example.demo1.entity.Login;
import com.example.demo1.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    LoginRepository loginRepository;


    public Profile getProfile(Integer id) {
        return profileRepository.findById(id).get();
    }

    public void deleteProfile(Integer id) {
        profileRepository.deleteById(id);
    }

    public Profile addProfile(Integer id,Profile profile) {
        Login login=loginRepository.findById(id).get();
        profile.setLogin_id(login);
        return profileRepository.save(profile);
    }

    public Profile UpdateProfile(Integer id, Profile profile) {
        Profile oldProfile=profileRepository.findById(id).orElse(null);
        if(oldProfile!=null){
            oldProfile.setFirstName(profile.getFirstName());
            oldProfile.setLastName(profile.getLastName());
            oldProfile.setContactNo(profile.getContactNo());
            oldProfile.setDob(profile.getDob());
            oldProfile.setDescription(profile.getDescription());
            return profileRepository.save(oldProfile);
        }
        return null;
    }
}
