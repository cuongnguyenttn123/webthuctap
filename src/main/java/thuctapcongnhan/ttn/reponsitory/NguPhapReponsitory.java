package thuctapcongnhan.ttn.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import thuctapcongnhan.ttn.entity.NguPhapEntity;

import javax.transaction.Transactional;

public interface NguPhapReponsitory  extends JpaRepository<NguPhapEntity, Integer> {
    NguPhapEntity findAllById(Integer id);
    @Transactional
    void deleteById(Integer id);
}
