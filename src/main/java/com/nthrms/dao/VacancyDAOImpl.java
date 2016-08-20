/**
 * 
 */
package com.nthrms.dao;

import org.springframework.stereotype.Repository;

import com.nthrms.pojo.Vacancy;

/**
 * @author Hoa Nguyen
 * 
 */
@Repository
public class VacancyDAOImpl extends AbstractDAOImpl<Vacancy, String> implements
	VacancyDAO {

    /**
     * @param entityClass
     */
    protected VacancyDAOImpl() {
	super(Vacancy.class);
    }

}
