package thuctapcongnhan.ttn.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import thuctapcongnhan.ttn.entity.TuVungEntity;

import javax.transaction.Transactional;

public interface TuVungReponsitory extends JpaRepository<TuVungEntity, Integer> {
    TuVungEntity findAllById(Integer id);
    @Transactional
    void deleteById(Integer id);
}
