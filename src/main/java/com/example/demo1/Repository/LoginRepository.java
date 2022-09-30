package com.example.demo1.Repository;

import com.example.demo1.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer> {
    public Login findByEmail(String email);
    public Login findByEmailAndPassword(String email,String password);
}
