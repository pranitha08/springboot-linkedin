package com.example.demo1.Repository;

import com.example.demo1.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience,Integer> {
}
