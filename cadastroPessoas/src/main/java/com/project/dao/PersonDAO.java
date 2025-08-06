package com.project.dao;

import com.project.entity.Person;
import jakarta.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonDAO {

    @PersistenceContext(unitName = "CadastroPU")
    private EntityManager em;

    public void save(Person person) {
        if (person.getId() == null) {
            em.persist(person);
        } else {
            em.merge(person);
        }
    }

    public void delete(Person person) {
        em.remove(em.merge(person));
    }

    public Person findById(Long id) {
        return em.find(Person.class, id);
    }

    public List<Person> findAll() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }
}
