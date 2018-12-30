package thuctapcongnhan.ttn.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thuctapcongnhan.ttn.entity.User;

@Repository
public interface UserReponsitory extends JpaRepository<User, Integer> {
    User findByUsername(String user);
    User findById(Integer id);
}
