package thuctapcongnhan.ttn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thuctapcongnhan.ttn.entity.TuVungEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

@Repository
@Transactional
public class TuVungDAO {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @org.springframework.transaction.annotation.Transactional
    public void themTuVung(TuVungEntity tuVungEntity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(tuVungEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateTuVungEntity(TuVungEntity tuVungEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(tuVungEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println();
    }
}
