package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.dto.ContratDto;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.ContratService;

import java.util.List;
@RequestMapping("/contrats")
@RestController
public class ContratRestControl{
    @Autowired
    private ContratService contratService;
    // Ajout de l'injection de dépendance

    // Récupérer tous les contrats
    @GetMapping("/retrieve-all-contrats")
    public List<Contrat> retrieveAllContrats() {

        return contratService.retrieveAllContrats();
    }

    // Récupérer un contrat par référence
    @GetMapping("/retrieve-contrat/{reference}")
    public Contrat retrieveContrat(@PathVariable("reference") Long reference) {
        return contratService.retrieveContrat(reference);
    }


    // Ajouter un contrat
    @PostMapping("/add-contrat")
    public Contrat addContrat(@RequestBody ContratDto contratDto) {
        return contratService.addContrat(contratDto);
    }

    // Modifier un contrat
    @PutMapping("/modify-contrat")
    public Contrat updateContrat(@RequestBody ContratDto contratDto) {
        return contratService.updateContrat(contratDto);
    }

    // Supprimer un contrat par référence
    @DeleteMapping("/remove-contrat/{reference}")
    public void removeContrat(@PathVariable("reference") Long reference) {
        contratService.deleteContrat(reference);
    }



}
