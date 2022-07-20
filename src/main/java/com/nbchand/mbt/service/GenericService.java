package com.nbchand.mbt.service;

import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-07-20
 */
public interface GenericService<T, U> {
    T save(T t);
    U findById(Integer id) throws Exception;
    List<U> findAll();
    Integer delete(Integer id) throws Exception;
}
