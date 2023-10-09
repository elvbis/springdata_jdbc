package pe.springdata.jdbc.person.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.springdata.jdbc.person.repository.entity.PersonEntity;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, String> {
    List<PersonEntity> findByFirstName(String firstName);

    @Modifying
    @Query("UPDATE person_entity SET first_name = :name WHERE id = :id")
    boolean updateByFirstName(@Param("id") Long id, @Param("name") String name);

}
