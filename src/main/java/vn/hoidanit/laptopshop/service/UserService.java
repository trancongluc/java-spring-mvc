package vn.hoidanit.laptopshop.service;


import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users;
    }
    public List<User> getAllUsersByEmail(String email) {
        List<User> users = this.userRepository.findByEmail(email);
        return users;
        // return users.stream().filter(user -> user.getEmail().equals(email)).toList();
    }
    public User handleSaveUser( User user) {
        // Logic to save user
        User newUser = this.userRepository.save(user);
       return newUser;
    }
}
