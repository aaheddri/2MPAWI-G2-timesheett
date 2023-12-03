package tn.esprit.spring.services;

import tn.esprit.spring.dto.ContratDto;
import tn.esprit.spring.entities.Contrat;

import java.util.List;

public interface ContratService {

    List<Contrat> retrieveAllContrats();

    Contrat addContrat(ContratDto contratDTO);

    Contrat updateContrat(ContratDto contratDTO);

    void deleteContrat(Long reference);


    Contrat retrieveContrat(Long reference);
}
