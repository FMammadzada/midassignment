package edu.ada.service.library.model.service.impl;

import edu.ada.service.library.model.dto.RegistrationModel;
import edu.ada.service.library.model.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ada.service.library.repository.UserRepository;
import edu.ada.service.library.model.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    protected static final Logger log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean registration(RegistrationModel registrationModel) {
        try {
            userRepository.save(new UserEntity(registrationModel));
            return true;
        } catch (Exception e) {

            log.error(e.getMessage());
            return false;
        }

    }

    @Override
    public int login(String email, String password) {

        UserEntity user;
        user = userRepository.findFirstByEmail(email);
        if (user != null && user.getId() > 0) {

            user = userRepository.findFirstByEmailAndPassword(email, password);

            if (user != null && user.getId() > 0) {
                return 1;
            } else {
                return 0;
            }

        } else {
            return 1;
        }
    }

    @Override
    public UserEntity findUser(String email, String password) {
        return userRepository.findFirstByEmailAndPassword(email, password);
    }

    @Override
    public void updateToken(UserEntity userEntity) {

    }

    @Override
    public UserEntity findUserByID(long id) {
        return userRepository.findById(id).get();
    }
}
