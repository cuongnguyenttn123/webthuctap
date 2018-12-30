package thuctapcongnhan.ttn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import thuctapcongnhan.ttn.entity.BaiHocEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
@Repository
@Transactional(rollbackFor = Exception.class)
public class BaiHocDAO {
    @Autowired
    EntityManagerFactory entityManagerFactory;

    public void themBaiHoc(BaiHocEntity baiHocEntity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(baiHocEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(baiHocEntity.getId());
    }

    public void updateBaiHocEntity(BaiHocEntity baiHocEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(baiHocEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
