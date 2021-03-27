package edu.ada.service.library.model.service;

import edu.ada.service.library.model.dto.RegistrationModel;
import edu.ada.service.library.model.entity.UserEntity;

public interface AuthenticationService {

    boolean registration(RegistrationModel registrationModel);

    int login(String email, String password);

    UserEntity findUser(String email, String password);

    void updateToken(UserEntity userEntity);

    UserEntity findUserByID(long id);

}
