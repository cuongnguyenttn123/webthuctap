package thuctapcongnhan.ttn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import thuctapcongnhan.ttn.entity.TuVungEntity;
import thuctapcongnhan.ttn.reponsitory.TuVungReponsitory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


@Repository
@Transactional(rollbackFor = Exception.class)
public class TuVungDAO {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    TuVungReponsitory tuVungReponsitory;

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

    public void deleteTuVung(Integer id){
        TuVungEntity tuVungEntity = tuVungReponsitory.findAllById(id);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(tuVungEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
