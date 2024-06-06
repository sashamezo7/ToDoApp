package org.example.maxpetapi.Service;

import org.example.maxpetapi.Models.User;
import org.example.maxpetapi.Response.Response;
import org.example.maxpetapi.entity.UsersEntity;
import org.example.maxpetapi.repository.UsersRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class UserService{
    private final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Response register(User user){
        try {
            UsersEntity newUser = new UsersEntity();
            newUser.setUsername(user.getUsername());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(user.getPassword());

            UsersEntity savedUser = usersRepository.save(newUser);

            if (savedUser != null) {
                return new Response(200,"Registration successful");

            } else {
                return new Response(100,"Registration failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(100,"Registration failed");

        }
    }
    public Response login(User user) {
        try {
            UsersEntity loggedInUser = usersRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

            if (loggedInUser != null) {
                return new Response(200, "Login successful");
            } else {
                return new Response(100, "Wrong Username or Password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(100, "Login failed: " + e.getMessage());
        }
    }


}
