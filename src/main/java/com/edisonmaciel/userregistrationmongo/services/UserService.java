package com.edisonmaciel.userregistrationmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edisonmaciel.userregistrationmongo.domain.User;
import com.edisonmaciel.userregistrationmongo.repository.UserRepository;
import com.edisonmaciel.userregistrationmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado."));
	}

}
