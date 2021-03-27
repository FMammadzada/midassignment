package edu.ada.service.library.repository;

import edu.ada.service.library.model.entity.ReservedPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservedPeriodRepository extends JpaRepository<ReservedPeriod, Integer> {

    ReservedPeriod findByBookNameAndAndUserId(String bookName, int userId);

    List<ReservedPeriod> findAllByUserId(int userId);


    List<ReservedPeriod> findAllByUserIdAndDateTaken(int userId, String date);


}
