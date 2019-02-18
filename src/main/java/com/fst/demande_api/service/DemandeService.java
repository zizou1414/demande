/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.demande_api.service;

import com.fst.demande_api.bean.Demande;

/**
 *
 * @author AMINE
 */
public interface DemandeService {

    public Demande findByReferenceDemande(String referenceDemande);

    public int creerDemande(Demande demande);

    public int validationChefDep(String referenceDemande);

    public int validationDoyen(String referenceDemande);
    
     public void deleteDemande (String referenceDemande);
    
}
