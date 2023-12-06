package tn.esprit.spring.services;

import tn.esprit.spring.entities.Employe;

import java.util.List;

public interface EmployeService {
    List<Employe> retrieveAllEmployee();
    Employe addEmploye(Employe emp);
    void deleteEmploye(String id);
    Employe updateEmploye(Employe emp);
    Employe retrieveEmploye(String id);

}
