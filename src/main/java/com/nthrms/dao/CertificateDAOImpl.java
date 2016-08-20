/**
 * 
 */
package com.nthrms.dao;

import org.springframework.stereotype.Repository;

import com.nthrms.pojo.Certificate;

/**
 * @author Hoa Nguyen
 * 
 */
@Repository
public class CertificateDAOImpl extends AbstractDAOImpl<Certificate, String>
	implements CertificateDAO {

    /**
     * @param entityClass
     */
    protected CertificateDAOImpl() {
	super(Certificate.class);
    }

}