package edu.ada.service.library.model.service.impl;

import edu.ada.service.library.model.entity.Books;
import edu.ada.service.library.model.entity.ReservedPeriod;
import edu.ada.service.library.model.service.ReservedPeriodService;
import edu.ada.service.library.repository.BookLibraryRepository;
import edu.ada.service.library.repository.ReservedPeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReservedPeriodImpl implements ReservedPeriodService {

    @Autowired
    private ReservedPeriodRepository reservedPeriodRepository;
    @Autowired
    private BookLibraryRepository bookLibraryRepository;


    @Override
    public void pickUp(int userId, String bookName) throws ParseException {

        ReservedPeriod reservedPeriod = new ReservedPeriod();
        Books books = bookLibraryRepository.findByName(bookName);
        reservedPeriod.setUserId(userId);
        reservedPeriod.setBookName(bookName);
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        reservedPeriod.setDateTaken(date);
        books.setReserved(userId);
        bookLibraryRepository.save(books);
        reservedPeriodRepository.save(reservedPeriod);


    }

    @Override
    public void dropOff(int userId, String bookName) throws ParseException {
        ReservedPeriod reservedPeriod = reservedPeriodRepository.findByBookNameAndAndUserId(bookName, userId);
        Books books = bookLibraryRepository.findByName(bookName);
        books.setReserved(0);
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        reservedPeriod.setDateDrop(date);
        bookLibraryRepository.save(books);
        reservedPeriodRepository.save(reservedPeriod);

    }

    @Override
    public List<ReservedPeriod> history(int userId) {
        return reservedPeriodRepository.findAllByUserId(userId);
    }

    @Override
    public List<ReservedPeriod> historyCurrently(int userId) throws ParseException {
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return reservedPeriodRepository.findAllByUserIdAndDateTaken(userId, date);
    }

    @Override
    public boolean checking(String bookname) {

        Books books = bookLibraryRepository.findByName(bookname);
        if (books.getReserved() == 0) {
            return true;
        }

        return false;
    }
}
