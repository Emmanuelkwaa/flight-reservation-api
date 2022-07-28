package com.skillstorm.flightreservationapi.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID>{

}
