package thuctapcongnhan.ttn.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thuctapcongnhan.ttn.entity.Role;
@Repository
public interface RoleReponsitory extends JpaRepository<Role, Integer> {
    Role findById(Integer id);
}
