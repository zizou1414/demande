/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.demande_api.service.impl;

import com.fst.demande_api.bean.Demande;
import com.fst.demande_api.bean.PersonnelMission;
import com.fst.demande_api.dao.DemandeDao;
import com.fst.demande_api.dao.PersonnelMissionDao;
import com.fst.demande_api.service.PersonnelMissionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMINE
 */
@Service
public class PersonnelMissionImpl implements PersonnelMissionService {

    @Autowired
    private PersonnelMissionService personnelMissionService;
    @Autowired
    private PersonnelMissionDao personnelMissionDao;


    public void setPersonnelMissionService(PersonnelMissionService personnelMissionService) {
        this.personnelMissionService = personnelMissionService;
    }

    public void setPersonnelMissionDao(PersonnelMissionDao personnelMissionDao) {
        this.personnelMissionDao = personnelMissionDao;
    }

    @Override
    public List<PersonnelMission> findByDemandeReferenceDemande(String referenceDemande) {
        return personnelMissionDao.findByDemandeReferenceDemande(referenceDemande);
    }

    @Override
    public PersonnelMission findByReferencePersonnel(String referencePersonnel) {
        return personnelMissionDao.findByReferencePersonnel(referencePersonnel);
    }

    @Override
    public int creerPersonnelMision(PersonnelMission personnelMission) {
        PersonnelMission pm = findByReferencePersonnel(personnelMission.getReferencePersonnel());
        if (pm != null) {
            return -1;
        } else {
            pm = new PersonnelMission();
            pm.setDemande(personnelMission.getDemande());
            pm.setReferencePersonnel(personnelMission.getReferencePersonnel());
            personnelMissionDao.save(pm);
            return 1;
        }

    }


}
