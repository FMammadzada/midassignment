package edu.ada.service.library.model.service;

import edu.ada.service.library.model.entity.ReservedPeriod;

import java.text.ParseException;
import java.util.List;

public interface ReservedPeriodService {

    void pickUp(int userId, String bookName) throws ParseException;

    void dropOff(int userId, String bookName) throws ParseException;

    List<ReservedPeriod> history(int userId);


    List<ReservedPeriod> historyCurrently(int userId) throws ParseException;


    boolean checking(String bookname);


}
