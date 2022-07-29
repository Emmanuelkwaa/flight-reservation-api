package com.skillstorm.flightreservationapi.data.repositories;

import org.springframework.stereotype.Repository;

import com.skillstorm.flightreservationapi.models.User;

@Repository
public interface UserRepository extends GenericRepository<User, Integer> {
}

