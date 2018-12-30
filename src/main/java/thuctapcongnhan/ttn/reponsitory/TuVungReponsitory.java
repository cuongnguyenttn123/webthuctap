package thuctapcongnhan.ttn.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import thuctapcongnhan.ttn.entity.TuVungEntity;

public interface TuVungReponsitory extends JpaRepository<TuVungEntity, Integer> {
    TuVungEntity findAllById(Integer id);
    @Transactional
    void deleteById(Integer id);
}
