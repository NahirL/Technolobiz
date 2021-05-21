package com.ar.tbz.services;


import com.ar.tbz.domain.User;

public interface UserService {
    Iterable<User> listAllUsers();

    User getUserById(Integer id);

    User saveUser(User user);

    void deleteUser(Integer id);
}
