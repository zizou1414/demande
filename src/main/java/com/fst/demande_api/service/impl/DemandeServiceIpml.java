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
import com.fst.demande_api.service.DemandeService;
import com.fst.demande_api.service.PersonnelMissionService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMINE
 */
@Service
public class DemandeServiceIpml implements DemandeService {

    @Autowired
    private DemandeDao demandeDao;
    @Autowired
    private PersonnelMissionService personnelMissionService;
    @Autowired
    private PersonnelMissionDao personnelMissionDao;

    public void setPersonnelMissionDao(PersonnelMissionDao personnelMissionDao) {
        this.personnelMissionDao = personnelMissionDao;
    }

    public void setDemandeDao(DemandeDao demandeDao) {
        this.demandeDao = demandeDao;
    }

    public void setPersonnelMissionService(PersonnelMissionService personnelMissionService) {
        this.personnelMissionService = personnelMissionService;
    }

    @Override
    public Demande findByReferenceDemande(String referenceDemande) {
        return demandeDao.findByReferenceDemande(referenceDemande);
    }

    @Override
    public int creerDemande(Demande demande) {
        Demande d = findByReferenceDemande(demande.getReferenceDemande());
        if (d != null) {
            return -1;
        } else {
            d = new Demande();
            d.setDateDemande(demande.getDateDemande());
            d.setReferenceDemande(demande.getReferenceDemande());
            d.setReferenceVille(demande.getReferenceVille());
            d.setObjetMission(demande.getObjetMission());
            d.setReferenceMoyenTransport(demande.getReferenceMoyenTransport());
            //d.setChauffeur(demande.getChauffeur());
            d.setPersonnelDescription(demande.getPersonnelDescription());
            d.setEstimationKilometrique(demande.getEstimationKilometrique());
            d.setDateDepart(demande.getDateDepart());
            d.setDateRetour(demande.getDateRetour());
            d.setHeureDepart(demande.getHeureDepart());
            d.setHeureRetour(demande.getHeureRetour());
//            d.setDateConfirmationDoyen(null);
//            d.setDateConfirmationChefDep(null);
//            d.setDateRefueChefDep(null);
//            d.setDateRefueDoyen(null);
            d.setEtatComfirmationChefDep(false);
            d.setEtatComfirmationDoyen(false);
            d.setPersonnelMissions(demande.getPersonnelMissions());
            d.setNombrePersonnel(demande.getPersonnelMissions().size());
              demandeDao.save(d);
            for (PersonnelMission personnelMission : demande.getPersonnelMissions()) {
                personnelMission.setDemande(d);
                personnelMissionService.creerPersonnelMision(personnelMission);

            }
            return 1;
        }
    }

    @Override
    public int validationChefDep(String referenceDemande) {
        Demande demande = findByReferenceDemande(referenceDemande);
        if (demande == null) {
            return -1;
        } else if (demande.isEtatComfirmationChefDep() == true) {
            return -2;
        } else if (demande.getDateDepart().before(new Date())) {
            demande.setDateRefueChefDep(new Date());
            demandeDao.save(demande);
            return -3;
        } else {
            demande.setDateConfirmationChefDep(new Date());
            demande.setEtatComfirmationChefDep(true);
            demandeDao.save(demande);
            return 1;
        }
    }

    @Override
    public int validationDoyen(String referenceDemande) {
        Demande demande = findByReferenceDemande(referenceDemande);
        if (demande == null) {
            return -1;
        } else if (demande.isEtatComfirmationChefDep() == false) {
            return -2;
        } else if (demande.isEtatComfirmationDoyen() == true) {
            return -3;
        } else if (demande.getDateDepart().before(new Date())) {
            demande.setDateRefueDoyen(new Date());
            demandeDao.save(demande);
            return -4;
        } else {
            demande.setDateConfirmationDoyen(new Date());
            demande.setEtatComfirmationDoyen(true);
            demandeDao.save(demande);
            return 1;
        }
    }

    @Override
    public void deleteDemande(String referenceDemande) {

        List<PersonnelMission> personnelMissions = personnelMissionService.findByDemandeReferenceDemande(referenceDemande);
        for (PersonnelMission personnelMission : personnelMissions) {
            personnelMissionDao.delete(personnelMission);

        }
        Demande demande = findByReferenceDemande(referenceDemande);
        demandeDao.delete(demande);

    }

}
