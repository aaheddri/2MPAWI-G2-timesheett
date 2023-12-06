package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.EmployeService;


import java.util.List;

@RestController
public class EmployeRestControl {

    private final EmployeService employeService;

    @Autowired
    public EmployeRestControl(EmployeService employeService) {
        this.employeService = employeService;

    }
    @GetMapping("/retrieve-all-employes")
    public List<Employe> retrieveAllEmployes() {
        return employeService.retrieveAllEmployee();
    }

    @GetMapping("/retrieve-employe/{employe-id}")
    public Employe retrieveEmploye(@PathVariable("employe-id") String employeId) {
        return employeService.retrieveEmploye(employeId);
    }

    @PostMapping("/add-employe")
    public Employe addEmploye(@RequestBody Employe emp) {
        return employeService.addEmploye(emp);
    }

    @DeleteMapping("/remove-employe/{employe-id}")
    public void removeEmploye(@PathVariable("employe-id") String employeId) {
        employeService.deleteEmploye(employeId);
    }

    @PutMapping("/modify-employe")
    public Employe updateEmploye(@RequestBody Employe employe) {
        return employeService.updateEmploye(employe);
    }
}
