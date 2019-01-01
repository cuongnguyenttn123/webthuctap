package thuctapcongnhan.ttn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thuctapcongnhan.ttn.entity.BaiVietEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class BaiVietDAO {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    public void themBaiViet(BaiVietEntity baiVietEntity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println();
        entityManager.getTransaction().begin();
        entityManager.persist(baiVietEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateBaiVietEntity(BaiVietEntity baiVietEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(baiVietEntity);
        System.out.println();
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
