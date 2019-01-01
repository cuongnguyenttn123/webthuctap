package thuctapcongnhan.ttn.reponsitory;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import thuctapcongnhan.ttn.entity.BaiVietEntity;


import java.util.List;
@Repository
public interface BaiVietReponsitory extends JpaRepository<BaiVietEntity, Integer> {
    BaiVietEntity findById(Integer id);
    @Transactional
    void deleteAllById(Integer id);

    @Query("SELECT  v from BaiVietEntity v where v.tenBaiViet like %?1%")
    List<BaiVietEntity> findByTenBaiViet(String seach, Pageable pageable);

}
