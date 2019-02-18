/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.demande_api.rest;

import com.fst.demande_api.bean.PersonnelMission;
import com.fst.demande_api.service.PersonnelMissionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AMINE
 */
@RequestMapping("/demande_api/missions")
@RestController()
public class PersonnelMissionRest {
    
    @Autowired 
    private PersonnelMissionService personnelMissiionService;

    public void setPersonnelMissiionService(PersonnelMissionService personnelMissiionService) {
        this.personnelMissiionService = personnelMissiionService;
    }
    @GetMapping("/reference/{referenceDemande}")
    public List<PersonnelMission> findByDemandeReferenceDemande(@PathVariable String referenceDemande) {
        return personnelMissiionService.findByDemandeReferenceDemande(referenceDemande);
    }

    public PersonnelMission findByReferencePersonnel(String referencePersonnel) {
        return personnelMissiionService.findByReferencePersonnel(referencePersonnel);
    }

    public int creerPersonnelMision(PersonnelMission personnelMission) {
        return personnelMissiionService.creerPersonnelMision(personnelMission);
    }
    
}
