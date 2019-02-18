/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.demande_api.dao;

import com.fst.demande_api.bean.PersonnelMission;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AMINE
 */
@Repository
public interface PersonnelMissionDao extends JpaRepository<PersonnelMission,Long>{
    public List<PersonnelMission> findByDemandeReferenceDemande (String referenceDemande);
    public PersonnelMission findByReferencePersonnel (String referencePersonnel);
}
