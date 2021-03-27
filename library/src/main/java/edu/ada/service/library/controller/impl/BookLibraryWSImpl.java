package edu.ada.service.library.controller.impl;

import edu.ada.service.library.controller.BookLibraryWS;
import edu.ada.service.library.model.dto.BookModel;
import edu.ada.service.library.model.entity.Books;
import edu.ada.service.library.model.service.BookLibraryService;
import edu.ada.service.library.model.service.ReservedPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookLibraryWSImpl implements BookLibraryWS {



    @Autowired
    private BookLibraryService bookLibraryService;



    @Autowired
    private ReservedPeriodService reservedPeriodService;


    @Override
    @RequestMapping(value = "/book/findByName", method = RequestMethod.GET)
    public ResponseEntity findByName(@RequestParam(name = "bookName", required = true) String bookName) {
        int result = bookLibraryService.findByName(bookName);


        return new ResponseEntity(bookLibraryService.findBookByName(bookName), HttpStatus.OK);

    }

    @Override
    @RequestMapping(value = "/book/findByAvailability", method = RequestMethod.GET)

    public ResponseEntity findAllByAvailability() {

            return ResponseEntity.ok(bookLibraryService.findAllBooksByReserved(0));
        }



    @Override
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity listOfBooks() {

        List<Books> list = bookLibraryService.findAll();

        List<BookModel> list1 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            BookModel bookModel = new BookModel();
            bookModel.setName(list.get(i).getName());
            bookModel.setUserId(list.get(i).getReserved());
            list1.add(bookModel);
        }

        return ResponseEntity.ok(list1);
    }

    @Override
    @RequestMapping(value = "/book/pickUp", method = RequestMethod.GET)
    public ResponseEntity pickUp(@RequestParam(name = "userId", required = true) int userId, @RequestParam(name = "bookName", required = true) String bookName) throws ParseException {
        if(reservedPeriodService.checking(bookName)) {
            reservedPeriodService.pickUp(userId, bookName);
            return ResponseEntity.ok("You Have Been Successfully Pick Up");
        }

        return ResponseEntity.ok("Sorry Book is not available");

    }

    @Override
    @RequestMapping(value = "/book/dropOff", method = RequestMethod.GET)

    public ResponseEntity dropOff(@RequestParam(name = "userId", required = true) int userId, @RequestParam(name = "bookName", required = true) String bookName) throws ParseException {
        reservedPeriodService.dropOff(userId, bookName);
        return ResponseEntity.ok("You Have Been Successfully Drop Off");
    }

    @Override
    @RequestMapping(value = "/book/history", method = RequestMethod.GET)
    public ResponseEntity history(@RequestParam(name = "userId", required = true) int userId) {
        return ResponseEntity.ok(reservedPeriodService.history(userId));
    }

    @Override
    @RequestMapping(value = "/book/historyCurrent", method = RequestMethod.GET)
    public ResponseEntity historyCurrently(@RequestParam(name = "userId", required = true) int userId) throws ParseException {
        return ResponseEntity.ok(reservedPeriodService.historyCurrently(userId));
    }


}
