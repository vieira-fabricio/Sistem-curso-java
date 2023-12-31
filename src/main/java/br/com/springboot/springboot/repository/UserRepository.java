package br.com.springboot.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.springboot.model.User;

public interface UserRepository extends JpaRepository <User, Integer>{

    public List<User> findByIdGreaterThan(Integer id);
    public User findByNameIgnoreCase(String name);
    public User findByNameAndUserName(String name, String UserName);
}
