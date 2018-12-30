package thuctapcongnhan.ttn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thuctapcongnhan.ttn.entity.NguPhapEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

@Repository
@Transactional
public class NguPhapDAO {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @org.springframework.transaction.annotation.Transactional
    public void themNguPhap(NguPhapEntity nguPhapEntity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(nguPhapEntity);
        System.out.println();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateTuVungEntity(NguPhapEntity nguPhapEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(nguPhapEntity);
        entityManager.getTransaction().commit();
        System.out.println();
        entityManager.close();
    }
}