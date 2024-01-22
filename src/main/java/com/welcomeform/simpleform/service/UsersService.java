package com.welcomeform.simpleform.service;

import com.welcomeform.simpleform.model.usersModel;
import com.welcomeform.simpleform.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UserRepository usersRepository;

    private UsersService(UserRepository usersRepository){
        this.usersRepository  = usersRepository;

    }
    public usersModel registerUser(String login, String password, String email) {
        if (login != null && password != null) {
            return null;
        }else {
            usersModel UsersModel = new usersModel();
            UsersModel.setLogin(login);
            UsersModel.setPassword(password);
            UsersModel.setEmail(email);

            return usersRepository.save(UsersModel);
        }
    }

        public usersModel authenticate (String login, String password){
            return usersRepository.findByLoginAndPassword(login, password).orElse(null);
        }
}


