package tn.esprit.spring.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Departement;


import java.text.ParseException;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartementServiceImplTest {
    @Autowired
    DepartementService departementService;

    @Test
    @Order(2)
    public void testAddDepartement() throws ParseException {
        Departement departement = new Departement("informatique1");
        Departement DepartemmentAdded = departementService.addDepartement(departement);
        Assertions.assertEquals(departement.getName(), DepartemmentAdded.getName());
    }

    @Test
    @Order(3)
    public void testModifyDepartement() throws ParseException   {
        Departement departement = new Departement("DepInfo");
        Departement departementUpdated  = departementService.updateDepartement(departement);
        Assertions.assertEquals(departement.getName(), departementUpdated.getName());
    }

    @Test
    @Order(5)
    public void testDeleteDepartement() {
        departementService.deleteDepartement("1");
        Assertions.assertNull(departementService.retrieveDepartement("1", "Info"));
    }

    @Order(4)
    public void testRetrieveDepartement() {
        Departement departementRetrieved = departementService.retrieveDepartement("1","Info");
        Assertions.assertEquals(5, departementRetrieved.getId());
    }

}
