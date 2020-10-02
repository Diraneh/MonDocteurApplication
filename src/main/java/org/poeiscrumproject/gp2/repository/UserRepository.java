package org.poeiscrumproject.gp2.repository;

import java.util.List;

import org.poeiscrumproject.gp2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLastname(String lastname);

    User findByUsername(String username);

    User findByEmail(String email);
    
    List<User> findAllByEmail(String email);
}
