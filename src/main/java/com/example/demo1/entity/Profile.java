package com.example.demo1.entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="profile")
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String first_name;

    private String last_name;

    private String dob;

    private String contact_no;

    private String description;


    @OneToOne(targetEntity = Login.class,cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="login_id",referencedColumnName = "id")
    private Login login_id;


    @OneToOne(targetEntity = Address.class,cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="address_id",referencedColumnName = "id")
    private Address address_id;

    @OneToMany(targetEntity = Education.class,cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private Set<Education> education;

    @OneToMany(targetEntity = Experience.class,cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private Set<Experience> experience;

    @OneToMany(targetEntity = Skills.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private Set<Skills> skill;
    public Set<Education> getEducations(){
        return  education;
    }
    public Set<Experience> getExperiences(){
        return experience;
    }
    public Set<Skills> getSkills(){
        return  skill;
    }
}
