package com.skillstorm.flightreservationapi.data.repositories;

import com.skillstorm.flightreservationapi.data.repositories.GenericRepository;
import com.skillstorm.flightreservationapi.services.interfaces.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public abstract class GenericRepositoryImpl<T, ID extends Serializable> implements GenericService<T, ID> {
    private final GenericRepository<T, ID> genericRepository;

    @Autowired
    public GenericRepositoryImpl(GenericRepository<T, ID> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Override
    public Optional<T> findById(ID entityId) {
        return genericRepository.findById(entityId);
    }

    @Override
    public List<T> findAll() {
        return genericRepository.findAll();
    }

    @Override
    public T save(T entity) {
        return genericRepository.save(entity);
    }

    @Override
    public T update(T entity) {
        return genericRepository.save(entity);
    }

    // todo move this to individual services to do business logic
    @Override
    public T updateById(T entity, ID entityId) {
        Optional<T> optional = genericRepository.findById(entityId);
        if (optional.isPresent()) {
            return genericRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(T entity) {
        genericRepository.delete(entity);
    }

    @Override
    public void deleteById(ID entityId) {
        genericRepository.deleteById(entityId);
    }
}
