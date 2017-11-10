package com.company.blog.services;

import java.util.List;


public interface CRUDservice<T> {
    T findOneById(Long id);
    Long saveOrUpdate(T domainObject);
    List<T> findAll();
    void deleteLongId(Long id);
}
