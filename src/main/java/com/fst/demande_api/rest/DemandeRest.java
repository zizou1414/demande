/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.demande_api.rest;

import com.fst.demande_api.bean.Demande;
import com.fst.demande_api.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AMINE
 */
@RequestMapping("/demande_api/demandes")
@RestController
public class DemandeRest {
    @Autowired
    private DemandeService demandeService ;

    public DemandeService getDemandeService() {
        return demandeService;
    }

    public void setDemandeService(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    public Demande findByReferenceDemande(String referenceDemande) {
        return demandeService.findByReferenceDemande(referenceDemande);
    }
    @PostMapping("/")
    public double creerDemande(@RequestBody Demande demande) {
        return demandeService.creerDemande(demande);
    }
    @PutMapping("/reference/{referenceDemande}") 
    public int validationChefDep(@PathVariable String referenceDemande) {
        return demandeService.validationChefDep(referenceDemande);
    }

    
    @PutMapping("/referenceDoy/{referenceDemande}") 
    public int validationDoyen(@PathVariable String referenceDemande) {
        return demandeService.validationDoyen(referenceDemande);
    }
    @DeleteMapping("/reference/{referenceDemande}")
    public void deleteDemande(@PathVariable String referenceDemande) {
        demandeService.deleteDemande(referenceDemande);
    }
    
    
    
    
    
    
}
