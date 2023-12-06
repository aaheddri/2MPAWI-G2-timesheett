package tn.esprit.spring.services;

import org.junit.jupiter.api.Test;
import tn.esprit.spring.dto.ContratDto;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ContratDtoTest {

    @Test
    void testContratDtoConstructor() {
        // Create sample data for testing
        Date dateDebut = new Date();
        String typeContrat = "Full-Time";
        float salaire = 50000.0f;

        // Create ContratDto object using the constructor
        ContratDto contratDto = new ContratDto(dateDebut, typeContrat, salaire);

        // Verify that the object is not null
        assertNotNull(contratDto);

        // Verify that the fields are set correctly
        assertEquals(dateDebut, contratDto.getDateDebut());
        assertEquals(typeContrat, contratDto.getTypeContrat());
        assertEquals(salaire, contratDto.getSalaire(), 0.001); // Specify a delta for float comparison
    }

}
