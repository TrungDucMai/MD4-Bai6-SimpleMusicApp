package com.codegym.respository;

import java.util.List;

public interface IGeneralRespo <T>{
    List<T> findAll();
    T findById (Long id);
    void save(T t);
    void remove (Long id);
}
