package edu.ada.service.library.controller;

import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Date;

public interface BookLibraryWS {
    ResponseEntity findByName(String bookName);

    ResponseEntity findAllByAvailability();


    ResponseEntity listOfBooks();

    ResponseEntity pickUp(int userId, String bookName) throws ParseException;

    ResponseEntity dropOff(int userId, String bookName) throws ParseException;


    ResponseEntity history(int userId);
    ResponseEntity historyCurrently(int userId) throws ParseException;


}
