/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.demande_api.dao;

import com.fst.demande_api.bean.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AMINE
 */
@Repository
public interface DemandeDao extends JpaRepository<Demande, Long>{
        public Demande findByReferenceDemande (String  referenceDemande);
     
       
    
}
