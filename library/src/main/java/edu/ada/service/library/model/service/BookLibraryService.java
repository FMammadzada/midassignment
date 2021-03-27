package edu.ada.service.library.model.service;

import edu.ada.service.library.model.entity.Books;

import java.util.List;

public interface BookLibraryService {
    int findByName(String name);

    int findAllByReserved(int reserved);

    Books findBookByName(String name);

    List<Books> findAllBooksByReserved(int reserved);

    List<Books> findAll();


}
