package tn.esprit.spring.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.dto.ContratDto;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class ContratServiceImpl  implements ContratService {
    @Autowired
    ContratRepository contratRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        List<Contrat> contrats = null;
        try {
            log.info("In Method retrieveAllContrats :");
            contrats = contratRepository.findAll();
            log.info("Out of Method retrieveAllContrats with Success : " + contrats.size());
        } catch (Exception e) {
            log.error("Out of Method retrieveAllContrats with Errors : ", e);
        }
        return contrats;
    }

    @Override
    public Contrat addContrat(ContratDto contratDTO) {
        log.info("In Method addContrat");
        Contrat contrat = new Contrat();
        convertDTOToEntity(contrat, contratDTO);
        Contrat contratAdded = null;
        try {
            log.info("In Method addContrat :");
            contratAdded = contratRepository.save(contrat);
            log.info("Out of Method addContrat with Success");
        } catch (Exception e) {
            log.error("Out of Method addContrat with Errors : ", e);
        }
        return contratAdded;
    }

    @Override
    public Contrat updateContrat(ContratDto contratDTO) {
        log.info("In Method updateContrat :");
        Contrat contratUpdated = null;

        try {
            Long reference = contratDTO.getReference();
            Optional<Contrat> optionalContrat = contratRepository.findById(reference);

            if (optionalContrat.isPresent()) {
                Contrat existingContrat = optionalContrat.get();
                updateEntityFromDTO(existingContrat, contratDTO);
                contratUpdated = contratRepository.save(existingContrat);
                log.info("Out of Method updateContrat with Success");
            } else {
                log.error("Contrat with reference {} not found", reference);
            }
        } catch (Exception e) {
            log.error("Out of Method updateContrat with Errors : ", e);
        }

        return contratUpdated;
    }

    @Override
    public void deleteContrat(Long reference) {
        try {
            log.info("In Method deleteContrat :");
            contratRepository.deleteById(reference);
            log.info("Out of Method deleteContrat with Success");
        } catch (Exception e) {
            log.error("Out of Method deleteContrat with Errors : ", e);
        }
    }


    @Override
    public Contrat retrieveContrat(Long reference) {
        Contrat contrat = null;
        try {
            log.info("In Method retrieveContrat :");
            contrat = contratRepository.findById(reference).orElse(null);
            log.info("Out of Method retrieveContrat with Success");
        } catch (Exception e) {
            log.error("Out of Method retrieveContrat with Errors : ", e);
        }
        return contrat;
    }

    private void convertDTOToEntity(Contrat contrat, ContratDto contratDTO) {
        contrat.setDateDebut(contratDTO.getDateDebut());
        contrat.setTypeContrat(contratDTO.getTypeContrat());
        contrat.setSalaire(contratDTO.getSalaire());
    }

    private void updateEntityFromDTO(Contrat existingContrat, ContratDto contratDTO) {
        existingContrat.setDateDebut(contratDTO.getDateDebut());
        existingContrat.setTypeContrat(contratDTO.getTypeContrat());
        existingContrat.setSalaire(contratDTO.getSalaire());
    }
}