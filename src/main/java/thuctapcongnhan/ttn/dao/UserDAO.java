package thuctapcongnhan.ttn.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import thuctapcongnhan.ttn.entity.Role;
import thuctapcongnhan.ttn.entity.User;
import thuctapcongnhan.ttn.entity.UsersRoles;
import thuctapcongnhan.ttn.reponsitory.RoleReponsitory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "userDAO")
@Transactional(rollbackFor = Exception.class)
public class UserDAO {
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    RoleReponsitory roleReponsitory;

    public User loadUserByUsername(final String username) {
        List<User> users = new ArrayList<User>();
        Session session = sessionFactory.getCurrentSession();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @org.springframework.transaction.annotation.Transactional
    public void themUser(User user){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        Role role = roleReponsitory.findById(2);
        UsersRoles usersRoles = new UsersRoles();
        usersRoles.setUsers(user);
        usersRoles.setRole(role);
        entityManager.persist(usersRoles);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
