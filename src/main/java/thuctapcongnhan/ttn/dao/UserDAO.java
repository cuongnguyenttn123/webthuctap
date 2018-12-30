package thuctapcongnhan.ttn.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import thuctapcongnhan.ttn.entity.User;

import java.util.ArrayList;
import java.util.List;

@Repository(value = "userDAO")
@Transactional(rollbackFor = Exception.class)
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public User loadUserByUsername(final String username) {
        List<User> users = new ArrayList<User>();
        Session session = sessionFactory.getCurrentSession();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }
}
