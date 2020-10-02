package org.poeiscrumproject.gp2.service;

import java.util.List;

import org.poeiscrumproject.gp2.model.User;
import org.poeiscrumproject.gp2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }
    
    public void deleteUser(User user){
    repository.delete(user);
    }
    
    public User getUserById(int id){
        return repository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username){return repository.findByUsername(username);}

    public boolean exist(User user){return repository.findById(user.getId()).isPresent();}


    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    public void updateUserSecurityCode(User user, String securityCode) {
        user.setSecurityCode(securityCode);
        repository.save(user);
    }

    public void updateUserPassword(User user, String password) {
        user.setPassword(password);
        repository.save(user);
    }
    
    public List<User> getAllUsers(){
        return repository.findAll();
    }
}
