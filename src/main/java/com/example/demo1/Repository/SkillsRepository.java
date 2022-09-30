package com.example.demo1.Repository;

import com.example.demo1.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills,Integer> {
}
