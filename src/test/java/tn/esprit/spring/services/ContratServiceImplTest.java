package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.dto.ContratDto;
import tn.esprit.spring.entities.Contrat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
class ContratServiceImplTest {

    @Autowired
    ContratService cn;


    @Test
    @Order(1)
    void testRetrieveAllContrats() {
        List<Contrat> contrats = cn.retrieveAllContrats();
        log.info("Liste des contrats récupérés :");
        for (Contrat contrat : contrats) {
            log.info("Contrat ID: {}, Libellé: {}, Date début: {}, Date fin: {}",
                    contrat.getReference(), contrat.getDateDebut(),contrat.getSalaire(), contrat.getTypeContrat());
        }
        Assertions.assertNotNull(contrats);
        Assertions.assertFalse(contrats.isEmpty());

        log.info("Number of contrats retrieved: {}", contrats.size());

        log.info("Test testRetrieveAllContrats completed successfully.");
    }

    @Test
    @Order(2)
    void testAddContrat() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = dateFormat.parse("2023-01-01");

        ContratDto contratDto = new ContratDto();
        contratDto.setDateDebut(d);
        contratDto.setTypeContrat("CDI");
        contratDto.setSalaire(5000.0f);

        Contrat contratAdded = cn.addContrat(contratDto);


        Assertions.assertNotNull(contratAdded);
        Assertions.assertEquals(contratDto.getTypeContrat(), contratAdded.getTypeContrat());
    }


    @Test
    @Order(3)
    void testUpdateContrat() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date newDateDebut = dateFormat.parse("2023-05-01");

        Contrat existingContrat = cn.retrieveAllContrats().get(0);

        // Mettez à jour tous les champs du contrat
        ContratDto contratDto = new ContratDto();
        contratDto.setReference(existingContrat.getReference());  // Assurez-vous que la référence est correcte
        contratDto.setDateDebut(newDateDebut);
        contratDto.setTypeContrat("CDD"); // Modifiez le type de contrat
        contratDto.setSalaire(6000.0f);  // Modifiez le salaire

        Contrat contratUpdated = cn.updateContrat(contratDto);

        Assertions.assertNotNull(contratUpdated);
        Assertions.assertEquals(newDateDebut, contratUpdated.getDateDebut());
        Assertions.assertEquals("CDD", contratUpdated.getTypeContrat());
        Assertions.assertEquals(6000.0f, contratUpdated.getSalaire());
    }

    @Test
    @Order(4)
    void testDeleteContrat() {
        List<Contrat> contratsBeforeDelete = cn.retrieveAllContrats();
        if (!contratsBeforeDelete.isEmpty()) {
            Long referenceToDelete = contratsBeforeDelete.get(0).getReference();
            cn.deleteContrat(referenceToDelete);
            List<Contrat> contratsAfterDelete = cn.retrieveAllContrats();
            Assertions.assertEquals(contratsBeforeDelete.size() - 1, contratsAfterDelete.size());
        } else {
            Assertions.fail("No contrats available for deletion");
        }
    }
    @Test
    @Order(5)
    void testRetrieveContrat() {
    // Récupérer la liste de tous les contrats
    List<Contrat> contrats = cn.retrieveAllContrats();
        if (!contrats.isEmpty()) {
            // Récupérer la référence du premier contrat pour le test
            Long referenceToRetrieve = contrats.get(0).getReference();
            // Ajouter un message log.info pour afficher la référence du contrat à récupérer
            log.info("Contrat à récupérer - Référence: {}", referenceToRetrieve);
            // Appeler la méthode pour récupérer le contrat
            Contrat retrievedContrat = cn.retrieveContrat(referenceToRetrieve);
            // Vérifier que le contrat récupéré n'est pas nul et a la bonne référence
            Assertions.assertNotNull(retrievedContrat);
            Assertions.assertEquals(referenceToRetrieve, retrievedContrat.getReference());
            // Ajouter un message log.info pour indiquer que le test de récupération a réussi
            log.info("Test retrieveContrat completed successfully.");
        } else {
            // Ajouter un message log.info pour indiquer qu'aucun contrat n'est disponible pour la récupération

            //utilisée pour enregistrer un message d'information dans les logs
            log.info("No contrats available for retrieval");
            //tilisée pour indiquer explicitement que le test a échoue
            Assertions.fail("No contrats available for retrieval");
        }
    }
}
