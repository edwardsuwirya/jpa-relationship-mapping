package com.enigmacamp.erjpa.repository;

import com.enigmacamp.erjpa.entity.UserCredential;

public interface AuthenticationRepository {
    void create(UserCredential userCredential);

    UserCredential findOne(String id);

}
