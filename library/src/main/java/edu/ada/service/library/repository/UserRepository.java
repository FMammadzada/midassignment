package edu.ada.service.library.repository;

import edu.ada.service.library.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {


    UserEntity findFirstByEmail(String email);
    UserEntity findFirstByEmailAndPassword(String email, String password);

}
