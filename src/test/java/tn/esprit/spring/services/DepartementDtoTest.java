package tn.esprit.spring.services;

import org.junit.jupiter.api.Test;
import tn.esprit.spring.dto.DepartementDto;

import static org.assertj.core.api.Assertions.assertThat;

 class DepartementDtoTest {

    @Test
     void testDepartementDto() {
        DepartementDto departementDto = new DepartementDto();
        departementDto.setId(1L);
        departementDto.setName("IT");

        assertThat(departementDto.getId()).isEqualTo(1L);
        assertThat(departementDto.getName()).isEqualTo("IT");
    }

}
