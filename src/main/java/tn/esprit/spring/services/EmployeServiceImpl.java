package tn.esprit.spring.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImpl implements EmployeService {

    private final EmployeRepository employeRepository;
    private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

    @Autowired
    public EmployeServiceImpl(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @Override
    public List<Employe> retrieveAllEmployee() {
        List<Employe> employes = null;
        try {
            l.info("In Method retrieveAllEmployes");
            employes = employeRepository.findAll();
            l.info("Out of Method retrieveAllEmployes with Success : {}", employes.size());
        } catch (Exception e) {
            l.error("Out of Method retrieveAllEmployes with Errors : ", e);
        }
        return employes;
    }

    @Override
    public Employe addEmploye(Employe emp) {
        Employe employe = null;
        try {
            l.info("In Method addEmploye");
            employe = employeRepository.save(emp);
            l.info("Out of Method addEmploye with Success : {}", employe);
        } catch (Exception e) {
            l.error("Error in addEmploye() : ", e);
        }
        return employe;
    }

    @Override
    public Employe updateEmploye(Employe emp) {
        Employe employeUpdated = null;
        try {
            l.info("In Method updateEmploye");
            employeUpdated = employeRepository.save(emp);
            l.info("Out of Method updateEmploye with Success : {}", employeUpdated);
        } catch (Exception e) {
            l.error("Error in updateEmploye() : ", e);
        }
        return employeUpdated;
    }

    @Override
    public void deleteEmploye(String id) {
        try {
            l.info("In Method deleteEmploye");
            employeRepository.deleteById(Long.parseLong(id));
            l.info("Out of Method deleteEmploye with Success");
        } catch (Exception e) {
            l.error("Error in deleteEmploye() : ", e);
        }
    }

    @Override
    public Employe retrieveEmploye(String id) {
        Employe emp = null;
        try {
            l.info("In Method retrieveEmploye");
            Optional<Employe> employeOptional = employeRepository.findById(Long.parseLong(id));
            if (employeOptional.isPresent()) {
                emp = employeOptional.get();
            }
            l.info("Out of Method retrieveEmploye with Success : {}", emp);
        } catch (Exception e) {
            l.error("Error in retrieveEmploye() : ", e);
        }
        return emp;
    }
}
