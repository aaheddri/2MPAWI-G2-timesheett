package tn.esprit.spring.services;

import org.junit.jupiter.api.Test;
import tn.esprit.spring.dto.ContratDto;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class ContratDtoTest {

    @Test
    void testContratDto() {
        // Création d'une instance de ContratDto
        Date dateDebut = new Date();
        String typeContrat = "CDI";
        float salaire = 5000.0f;

        ContratDto contratDto = new ContratDto(dateDebut, typeContrat, salaire);

        // Assertions avec AssertJ
        assertThat(contratDto).isNotNull();
        assertThat(contratDto.getDateDebut()).isEqualTo(dateDebut);
        assertThat(contratDto.getTypeContrat()).isEqualTo(typeContrat);
        assertThat(contratDto.getSalaire()).isEqualTo(salaire);
    }

}
