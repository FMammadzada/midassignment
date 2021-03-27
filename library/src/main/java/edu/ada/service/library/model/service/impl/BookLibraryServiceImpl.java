package edu.ada.service.library.model.service.impl;

import edu.ada.service.library.model.entity.Books;
import edu.ada.service.library.model.service.BookLibraryService;
import edu.ada.service.library.repository.BookLibraryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLibraryServiceImpl implements BookLibraryService {

    protected static final Logger log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Autowired
    private BookLibraryRepository bookLibraryRepository;


    @Override
    public int findByName(String name) {
        Books books;
        books = bookLibraryRepository.findByName(name);
        if (books != null && books.getId() > 0) {

            books = bookLibraryRepository.findByName(name);

            if (books != null && books.getId() > 0) {
                return 1;
            } else {
                return 0;
            }

        } else {
            return 1;
        }
    }

    @Override
    public int findAllByReserved(int reserved) {
        List<Books> books;
        books = bookLibraryRepository.findAllByReserved(reserved);
        if (books != null && books.size() == 0) {

            books = bookLibraryRepository.findAllByReserved(reserved);

            if (books != null && books.size() == 0) {
                return 1;
            } else {
                return 0;
            }

        } else {
            return 1;
        }
    }

    @Override
    public Books findBookByName(String name) {
        return bookLibraryRepository.findByName(name);
    }

    @Override
    public List<Books> findAllBooksByReserved(int reserved) {
        return bookLibraryRepository.findAllByReserved(reserved);
    }

    @Override
    public List<Books> findAll() {



        return bookLibraryRepository.findAll();
    }


}
