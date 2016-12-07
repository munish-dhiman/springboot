package edu.learning.munish.core.data.repository;

import edu.learning.munish.core.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Munish Kumar on 07-12-2016.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByName(@Param("name") String name);

    Person findByUuid(@Param("uuid") String uuid);
}
