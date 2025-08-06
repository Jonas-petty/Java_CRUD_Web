package com.project.controller;

import com.project.common.Sex;
import com.project.entity.Person;
import com.project.service.PersonService;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("personBean")
@ViewScoped
public class PersonBean implements Serializable {

    @EJB
    private PersonService personService;

    private Person person = new Person();

    private List<Person> people;

    public void save() {
        personService.save(person);
        person = new Person();
        people = null;
    }

    public void edit(Person selected) {
        this.person = selected;
    }

    public void delete(Person selected) {
        personService.delete(selected);
        people = null;
    }

    public List<Person> getPeople() {
        if (people == null) {
            people = personService.findAll();
        }
        return people;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Sex[] getSexOptions() {
        return Sex.values();
    }

}
