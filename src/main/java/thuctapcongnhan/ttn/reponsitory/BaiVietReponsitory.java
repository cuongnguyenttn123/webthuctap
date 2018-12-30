package thuctapcongnhan.ttn.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import thuctapcongnhan.ttn.entity.BaiVietEntity;

public interface BaiVietReponsitory extends JpaRepository<BaiVietEntity, Integer> {
    BaiVietEntity findById(Integer id);
}
