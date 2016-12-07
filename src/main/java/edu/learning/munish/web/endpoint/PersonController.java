package edu.learning.munish.web.endpoint;

import edu.learning.munish.core.service.UserService;
import edu.learning.munish.web.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This Controller gives brief information about the working of the rest controllers in Spring</br>framework
 * Created by Munish Kumar on 07-12-2016.
 */
@RestController()
@RequestMapping("/user")
public class PersonController {

    @Autowired
    private UserService userService;

    /**
     * This Endpoint is responsible for registering new user into the application
     *
     * @param personDto
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public PersonDto register(@RequestBody PersonDto personDto) {
        String register = userService.register(personDto);

        personDto.setId(register);
        return personDto;
    }

    /**
     * Using this endpoint one can find the details of a user registered with the application
     *
     * @param personId It is the unique id value that need to be passed to get information about a user
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PersonDto get(@PathVariable("id") String personId) {
        return userService.getPerson(Long.valueOf(personId));
    }

    /**
     * To update details of a person. uniqueId can not be updated
     *
     * @param personDto
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public PersonDto update(@RequestBody PersonDto personDto) {
        personDto = userService.updatePerson(personDto);
        return personDto;
    }

}
