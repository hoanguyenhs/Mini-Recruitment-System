/**
 * 
 */
package com.nthrms.service;

import java.util.List;

import com.nthrms.model.CandidateModel;
import com.nthrms.model.VacancyModel;
import com.nthrms.pojo.Phase;
import com.nthrms.pojo.Vacancy;

/**
 * @author Hoa Nguyen
 * 
 */
public interface VacancyService {

    Vacancy toPojo(VacancyModel vacancyModel);

    VacancyModel toModel(Vacancy vacancy);

    int countByName(String name);

    int getIdByName(String name);

    void create(VacancyModel vacancyModel);

    VacancyModel getById(Integer id);

    boolean status(Integer id);

    List<VacancyModel> search(VacancyModel vacancyModel);

    void delete(Integer id);

    void createPhase(Integer id);

    List<Phase> getPhase(Integer id);

    void filter(Integer id);

    List<CandidateModel> getCandidateInPhase(Integer id, String name);

    void reviewPass(Integer idV, Integer idC);

    void reviewReject(Integer idV, Integer idC);

    void entranceTestPass(Integer idV, Integer idC);

    void entranceTestReject(Integer idV, Integer idC);
    
    void interviewPass(Integer idV, Integer idC);

    void interviewReject(Integer idV, Integer idC);
    
    void offerPass(Integer idV, Integer idC);

    void offerReject(Integer idV, Integer idC);

}
