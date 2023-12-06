package tn.esprit.spring.services;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;
@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> retrieveAllUsers() {
        List<User> users = null;
        try {
            log.info("In Method retrieveAllUsers :");
            users = userRepository.findAll();
            log.info("Out of Method retrieveAllUsers with Success : " + users.size());
        } catch (Exception e) {
            log.error("Out of Method retrieveAllUsers with Errors : ", e);
        }
        return users;
    }

    @Override
    public User addUser(User u) {
        User utilisateur = null;
        try {
            log.info("Adding new user");
            utilisateur = userRepository.save(u);
            log.info("User added successfully with id: {}", utilisateur.getId());
        } catch (Exception e) {
            log.error("Error in addUser(): {}", e.getMessage(), e);
        }
        return utilisateur;
    }

    @Override
    public User updateUser(User u) {
        User userUpdated = null;
        try {
            log.info("Updating user with id: {}", u.getId());
            userUpdated = userRepository.save(u);
            log.info("User updated successfully with id: {}", userUpdated.getId());
        } catch (Exception e) {
            log.error("Error in updateUser(): {}", e.getMessage(), e);
            // Handle the exception or rethrow it if necessary
        }
        return userUpdated;
    }

    @Override
    public void deleteUser(String id) {
        try {
            log.info("Deleting user with id: {}", id);

            userRepository.deleteById(Long.parseLong(id));

            log.info("User deleted successfully with id: {}", id);

        } catch (NumberFormatException e) {
            log.error("Invalid id format in deleteUser(): {}", id, e);
            // Handle the exception or rethrow it if necessary

        } catch (Exception e) {
            log.error("Error in deleteUser(): {}", e.getMessage(), e);
            // Handle the exception or rethrow it if necessary
        }
    }
    public User retrieveUser(String id) {
        try {
            log.info("Retrieving user with id: {}", id);
            Optional<User> optionalUser = userRepository.findById(Long.parseLong(id));
            User retrievedUser = optionalUser.orElse(null);
            if (retrievedUser != null) {
                log.info("User retrieved successfully with id: {}", id);
            } else {
                log.info("User not found with id: {}", id);
            }
            return retrievedUser;
        } catch (Exception e) {
            log.error("Error in retrieveUser(): {}", e.getMessage(), e);
            return null;
        }
    }
}