package com.example.springtest.services;

import com.example.springtest.entities.User;
import com.example.springtest.pojos.UserDto;
import com.example.springtest.repositories.TaskRepository;
import com.example.springtest.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public User userSignUp(UserDto userDto) {
        User user = new User();
//        if (user.getName() == null)
//            throw new NameCannotBeEmptyException("Name cannot be empty!");
//        else if (user.getEmail() == null)
//            throw new EmailCannotBeEmptyException ("Email cannot be empty!");
//        else if (user.getPassword() == null)
//            throw new PasswordCannotBeEmptyException ("Password cannot be empty!")

            //boolean userExist = userRepository.existsById(user.)
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return userRepository.save(user);


    }

    @Override
    public User userLogin(String email, String password) {

        User user = new User();
        if ((Objects.equals(user.getEmail(), email)) && (Objects.equals(user.getPassword(), password))) {
            return user;
        }


        return null;
    }
}
