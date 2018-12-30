package thuctapcongnhan.ttn.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import thuctapcongnhan.ttn.entity.BaiHocEntity;

import java.util.List;

public interface BaiHocReponsitory extends JpaRepository<BaiHocEntity, Integer> {
    BaiHocEntity findAllById(Integer id);
    @Transactional
    void deleteById(Integer id);
    List<BaiHocEntity> findByLevel(String level);
}
