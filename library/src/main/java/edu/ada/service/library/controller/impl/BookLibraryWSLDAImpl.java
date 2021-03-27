package edu.ada.service.library.controller.impl;

import edu.ada.service.library.controller.BookLibraryWS;
import org.springframework.http.ResponseEntity;

public class BookLibraryWSLDAImpl implements BookLibraryWS {
    @Override
    public ResponseEntity findByName(String bookName) {
        return null;
    }

    @Override
    public ResponseEntity findAllByAvailability() {
        return null;
    }


    @Override
    public ResponseEntity listOfBooks() {
        return null;
    }

    @Override
    public ResponseEntity pickUp(int userId, String bookName) {
        return null;
    }

    @Override
    public ResponseEntity dropOff(int userId, String bookName) {
        return null;
    }

    @Override
    public ResponseEntity history(int userId) {
        return null;
    }

    @Override
    public ResponseEntity historyCurrently(int userId) {
        return null;
    }


}
