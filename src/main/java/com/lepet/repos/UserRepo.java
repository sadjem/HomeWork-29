package com.lepet.repos;

import com.lepet.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository <User, Long> {
    List<User> findBySecondName (String secondName);
}
