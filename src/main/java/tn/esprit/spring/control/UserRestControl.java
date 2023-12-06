package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

// userRestControl
@RestController // = @Controller + @ResponseBody
//@Scope("session")
// singleton c'est par défaut
// prototype
// request
public class UserRestControl {

    @Autowired
    IUserService userService;


    // URL : http://localhost:????/????/retrieve-all-users
    @GetMapping("/retrieve-all-users")
    public List<User> retrieveAllUsers() {
        return userService.retrieveAllUsers();
    }

    @GetMapping("/retrieve-user/{user-id}")
    public User retrieveUser(@PathVariable("user-id") String userId) {
        return userService.retrieveUser(userId);
    }



    // Ajouter User : http://localhost:????/timesheet-devops/add-user
    //@PostMapping("/add-user")



    // Supprimer User :
    @DeleteMapping("/remove-user/{user-id}")
    public void removeUser(@PathVariable("user-id") String userId) {
        userService.deleteUser(userId);
    }

    // Modifier User
    // http://localhost:????/timesheet-devops/modify-user

   // @PutMapping("/modify-user")


}
