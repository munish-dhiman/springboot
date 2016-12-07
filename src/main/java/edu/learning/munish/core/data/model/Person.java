package edu.learning.munish.core.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Munish Kumar on 07-12-2016.
 */
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String uuid = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String name;

    @Temporal(value = TemporalType.DATE)
    private Date doj = new Date();

    private String address;
    private String firstName;
    private String lastName;

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}