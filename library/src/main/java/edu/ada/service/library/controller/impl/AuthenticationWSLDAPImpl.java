package edu.ada.service.library.controller.impl;

import edu.ada.service.library.controller.AuthenticationWS;
import edu.ada.service.library.model.dto.RegistrationModel;
import org.springframework.http.ResponseEntity;

public class AuthenticationWSLDAPImpl implements AuthenticationWS {

    @Override
    public ResponseEntity login(String email, String password) {
        return null;
    }

    @Override
    public ResponseEntity register(RegistrationModel formData) {
        return null;
    }
}
