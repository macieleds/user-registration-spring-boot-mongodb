package com.edisonmaciel.userregistrationmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.edisonmaciel.userregistrationmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
