package com.project2.spacepals.repositories;

import java.util.List;

public interface CrudRepositories<T> {
    List<T> findAll();
    T findById(int id);
    T save(T newObj);
    boolean update(T updatedObj);
    boolean deleteById(T deletedObj);

}
