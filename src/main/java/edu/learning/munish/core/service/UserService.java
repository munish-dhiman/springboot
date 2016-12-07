package edu.learning.munish.core.service;

import edu.learning.munish.core.data.model.Person;
import edu.learning.munish.core.data.repository.PersonRepository;
import edu.learning.munish.core.exception.DocuException;
import edu.learning.munish.web.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by Munish Kumar on 07-12-2016.
 */
@Service
public class UserService {

    @Autowired
    private PersonRepository personRepository;

    public String register(PersonDto personDto) {
        try {
            String firstName = personDto.getFirstName();
            Assert.hasLength(firstName, "First name can not be an empty or null");

            String lastName = personDto.getLastName();
            Assert.hasLength(lastName, "Last name can not be an empty or null");

            Person person = new Person();
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setName(firstName + " " + lastName);
            person.setAddress(person.getAddress());
            person = personRepository.save(person);

            return person.getUuid();
        } catch (IllegalArgumentException ex) {
            throw new DocuException(ex.getMessage(), 400);
        }
    }

    public PersonDto getPerson(long id) {
        try {
            Person person = personRepository.findOne(id);
            Assert.notNull(person, "No person found with the id provided.");

            PersonDto personDto = new PersonDto();
            personDto.setFirstName(person.getFirstName());
            personDto.setLastName(person.getLastName());
            personDto.setAddress(person.getAddress());
            return personDto;
        } catch (IllegalArgumentException ex) {
            throw new DocuException(ex.getMessage(), 400);
        }
    }

    public PersonDto updatePerson(PersonDto personDto) {
        try {
            String id = personDto.getId();
            Assert.notNull(id, "Missing parameters");

            Person person = personRepository.findByUuid(id);
            Assert.notNull(person, "No person found with the id provided.");

            boolean updateName = false;
            String firstName = personDto.getFirstName();
            if (firstName != null && firstName.trim().length() > 0) {
                person.setFirstName(firstName);
                updateName = true;
            }
            String lastName = personDto.getLastName();
            if (lastName != null && lastName.trim().length() > 0) {
                person.setLastName(lastName);
                updateName = true;
            }

            if (updateName) {
                person.setName(firstName + " " + lastName);
            }


            String address = person.getAddress();
            if (address != null && address.trim().length() > 0) {
                person.setAddress(address);
            }
            person = personRepository.save(person);

            personDto = new PersonDto();
            personDto.setFirstName(person.getFirstName());
            personDto.setLastName(person.getLastName());
            personDto.setAddress(person.getAddress());
            return personDto;
        } catch (IllegalArgumentException ex) {
            throw new DocuException(ex.getMessage(), 400);
        }
    }
}
