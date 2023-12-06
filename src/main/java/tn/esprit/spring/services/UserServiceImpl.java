package tn.esprit.spring.services;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.UserRepository;
@Slf4j
@Service
public class UserServiceImpl {
    @Autowired
    UserRepository userRepository;
}