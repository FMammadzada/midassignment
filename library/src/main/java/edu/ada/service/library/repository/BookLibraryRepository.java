package edu.ada.service.library.repository;

import edu.ada.service.library.model.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookLibraryRepository extends JpaRepository<Books, Integer> {

    Books findByName(String name);

    List<Books> findAllByReserved(int reserved);

}
