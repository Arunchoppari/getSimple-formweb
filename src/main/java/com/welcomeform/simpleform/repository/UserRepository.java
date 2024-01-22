package com.welcomeform.simpleform.repository;

import com.welcomeform.simpleform.model.usersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<usersModel,Integer> {
     Optional<usersModel> findByLoginAndPassword(String login,String password);

}
