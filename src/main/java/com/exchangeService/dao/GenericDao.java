package com.exchangeService.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> { //delete PK or make PK an argument of methods
    T create();

    T persist(T object) throws PersistException;//WAT?

    T getByPK(int PK) throws PersistException; // or PK or delete

    void update(T object) throws PersistException;

    void delete(T object) throws PersistException;

    List<T> getAll() throws PersistException;
}
