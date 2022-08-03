package com.skillstorm.flightreservationapi.services.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.flightreservationapi.data.repositories.GenericRepositoryImpl;
import com.skillstorm.flightreservationapi.data.repositories.UserRepository;
import com.skillstorm.flightreservationapi.models.User;
import com.skillstorm.flightreservationapi.services.interfaces.UserServiceInterface;

@Service
@Transactional
public class UserService extends GenericRepositoryImpl<User, Integer> implements UserServiceInterface{
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		super(userRepository);
		this.userRepository = userRepository;
	}
}
