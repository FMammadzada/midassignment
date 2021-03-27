package edu.ada.service.library.controller.impl;

import edu.ada.service.library.controller.AuthenticationWS;
import edu.ada.service.library.model.dto.RegistrationModel;
import edu.ada.service.library.model.entity.UserEntity;
import edu.ada.service.library.model.service.AuthenticationService;
import edu.ada.service.library.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationWSImpl implements AuthenticationWS {



    @Autowired
    private AuthenticationService authenticationService;

    @Override
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity login(
            @RequestHeader("email") String email,
            @RequestHeader("password") String password
    ) {

        UserEntity userEntity = authenticationService.findUser(email, MD5.hashing(password));
        if (userEntity != null) {


            return ResponseEntity.ok()
                    .body("You Have Been Successfully Authorized");
        }
        return ResponseEntity.badRequest().body("Wrong credentials");

    }


    @Override
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity register(
            @RequestBody RegistrationModel formData
    ) {
        formData.setPassword(MD5.hashing(formData.getPassword()));

        if (authenticationService.registration(formData)) {

            return ResponseEntity.created(null).build();
        } else {
            return ResponseEntity.unprocessableEntity().build();
        }

    }
}
