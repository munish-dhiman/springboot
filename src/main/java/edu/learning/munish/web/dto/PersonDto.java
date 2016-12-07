package edu.learning.munish.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Its a Data Transfer object to be used to transfer data to and from a device using http protocol
 * Created by Munish Kumar on 07-12-2016.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDto {

    /**
     * Unique Id of the registered user
     */
    private String id;

    /**
     * First Nam of the user
     */
    private String firstName;

    /**
     * Last name of the user
     */
    private String lastName;

    /**
     * Address of the user
     */
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
