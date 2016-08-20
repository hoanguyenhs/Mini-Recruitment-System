package com.nthrms.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

/**
 * @author Hoa Nguyen
 * 
 */
public interface AbstractDAO<E, I extends Serializable> {

    void saveOrUpdate(E e);

    void delete(E e);
    
    E getById(I id);
    
    List<E> getAll();

    List<E> getByCriteria(Criterion criterion);
    
    List<E> getByCriteria(List<Criterion> criterionList);
}
