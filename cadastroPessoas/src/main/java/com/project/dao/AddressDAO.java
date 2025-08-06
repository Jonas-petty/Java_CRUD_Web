package com.project.dao;

import com.project.entity.Address;
import jakarta.ejb.Stateless;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class AddressDAO {

    @PersistenceContext(unitName = "CadastroPU")
    private EntityManager em;

    public void save(Address address) {
        if (address.getId() == null) {
            em.persist(address);
        } else {
            em.merge(address);
        }
    }

    public void delete(Address address) {
        em.remove(em.merge(address));
    }

    public Address findById(Long id) {
        return em.find(Address.class, id);
    }
}
