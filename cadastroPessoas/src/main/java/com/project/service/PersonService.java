package com.project.service;

import com.project.dao.PersonDAO;
import com.project.entity.Person;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class PersonService {

    @EJB
    private PersonDAO personDAO;

    public void save(Person person) {
        personDAO.save(person);
    }

    public void delete(Person person) {
        personDAO.delete(person);
    }

    public Person findById(Long id) {
        return personDAO.findById(id);
    }

    public List<Person> findAll() {
        return personDAO.findAll();
    }
}
