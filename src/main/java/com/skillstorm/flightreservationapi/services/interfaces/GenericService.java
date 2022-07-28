package com.skillstorm.flightreservationapi.services.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID extends Serializable>{
    Optional<T> findById(ID entityId);
    List<T> findAll(); // you might want a generic Collection if u prefer
    T save(T entity);
    T update(T entity);
    T updateById(T entity, ID entityId);
    void delete(T entity);
    void deleteById(ID entityId);
}
