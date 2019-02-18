/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.demande_api.service;

import com.fst.demande_api.bean.PersonnelMission;
import java.util.List;

/**
 *
 * @author AMINE
 */
public interface PersonnelMissionService {

    public List<PersonnelMission> findByDemandeReferenceDemande(String referenceDemande);

    public PersonnelMission findByReferencePersonnel(String referencePersonnel);

    public int creerPersonnelMision(PersonnelMission personnelMission);
  
  
     
}
