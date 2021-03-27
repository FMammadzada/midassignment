package edu.ada.service.library.controller;

import edu.ada.service.library.model.dto.RegistrationModel;
import org.springframework.http.ResponseEntity;

public interface AuthenticationWS {
    ResponseEntity login(String email, String password);

    ResponseEntity register(RegistrationModel formData);


}
