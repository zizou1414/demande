/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.demande_api.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author AMINE
 */
@Entity
public class Demande implements Serializable {

    @OneToMany(mappedBy = "demande")
    private List<PersonnelMission> personnelMissions;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numero;
    private String referenceDemande;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDemande;
    private String referenceVille;
    private String objetMission;
    private String referenceMoyenTransport;
   // private String chauffeur;
    //private String referencePersonnel;
    private String personnelDescription;
    private int nombrePersonnel;
    private double EstimationKilometrique;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDepart;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRetour;
    private String heureDepart;
    private String heureRetour;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateConfirmationChefDep;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateConfirmationDoyen;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRefueChefDep;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRefueDoyen;
    private double kilometrageAller;
    private double kilometrageRetour;

    
    private boolean EtatComfirmationChefDep;
    private boolean EtatComfirmationDoyen;
  

    @JsonIgnore
    public List<PersonnelMission> getPersonnelMissions() {
        return personnelMissions;
    }

    @JsonSetter
    public void setPersonnelMissions(List<PersonnelMission> personnelMissions) {
        this.personnelMissions = personnelMissions;
    }
    

//    public String getChauffeur() {
//        return chauffeur;
//    }
//
//    public void setChauffeur(String chauffeur) {
//        this.chauffeur = chauffeur;
//    }

    public String getReferenceDemande() {
        return referenceDemande;
    }

    public void setReferenceDemande(String referenceDemande) {
        this.referenceDemande = referenceDemande;
    }

    public String getPersonnelDescription() {
        return personnelDescription;
    }
    

    public void setPersonnelDescription(String personnelDescription) {
        this.personnelDescription = personnelDescription;
    }

    public int getNombrePersonnel() {
        return nombrePersonnel;
    }

    public void setNombrePersonnel(int nombrePersonnel) {
        this.nombrePersonnel = nombrePersonnel;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public String getReferenceVille() {
        return referenceVille;
    }

    public void setReferenceVille(String referenceVille) {
        this.referenceVille = referenceVille;
    }

    public String getObjetMission() {
        return objetMission;
    }

    public void setObjetMission(String objetMission) {
        this.objetMission = objetMission;
    }

    public String getReferenceMoyenTransport() {
        return referenceMoyenTransport;
    }

    public void setReferenceMoyenTransport(String referenceMoyenTransport) {
        this.referenceMoyenTransport = referenceMoyenTransport;
    }

//    public String getReferencePersonnel() {
//        return referencePersonnel;
//    }
//
//    public void setReferencePersonnel(String referencePersonnel) {
//        this.referencePersonnel = referencePersonnel;
//    }

    public double getEstimationKilometrique() {
        return EstimationKilometrique;
    }

    public void setEstimationKilometrique(double EstimationKilometrique) {
        this.EstimationKilometrique = EstimationKilometrique;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getHeureRetour() {
        return heureRetour;
    }

    public void setHeureRetour(String heureRetour) {
        this.heureRetour = heureRetour;
    }

    public Date getDateConfirmationChefDep() {
        return dateConfirmationChefDep;
    }

    public void setDateConfirmationChefDep(Date dateConfirmationChefDep) {
        this.dateConfirmationChefDep = dateConfirmationChefDep;
    }

    public Date getDateConfirmationDoyen() {
        return dateConfirmationDoyen;
    }

    public void setDateConfirmationDoyen(Date dateConfirmationDoyen) {
        this.dateConfirmationDoyen = dateConfirmationDoyen;
    }

    public Date getDateRefueChefDep() {
        return dateRefueChefDep;
    }

    public void setDateRefueChefDep(Date dateRefueChefDep) {
        this.dateRefueChefDep = dateRefueChefDep;
    }

    public Date getDateRefueDoyen() {
        return dateRefueDoyen;
    }

    public void setDateRefueDoyen(Date dateRefueDoyen) {
        this.dateRefueDoyen = dateRefueDoyen;
    }

    public boolean isEtatComfirmationChefDep() {
        return EtatComfirmationChefDep;
    }

    public void setEtatComfirmationChefDep(boolean EtatComfirmationChefDep) {
        this.EtatComfirmationChefDep = EtatComfirmationChefDep;
    }

    public boolean isEtatComfirmationDoyen() {
        return EtatComfirmationDoyen;
    }

    public void setEtatComfirmationDoyen(boolean EtatComfirmationDoyen) {
        this.EtatComfirmationDoyen = EtatComfirmationDoyen;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demande)) {
            return false;
        }
        Demande other = (Demande) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fst.demande_api.bean.Demande[ numero=" + numero + " ]";
    }

}
