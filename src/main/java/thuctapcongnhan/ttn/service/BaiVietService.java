package thuctapcongnhan.ttn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thuctapcongnhan.ttn.converter.BaiVietConvertor;
import thuctapcongnhan.ttn.dao.BaiVietDAO;
import thuctapcongnhan.ttn.domain.BaiVietReponse;
import thuctapcongnhan.ttn.entity.BaiVietEntity;
import thuctapcongnhan.ttn.entity.User;
import thuctapcongnhan.ttn.reponsitory.BaiVietReponsitory;

import java.util.List;

@Service
@Transactional
public class BaiVietService {
    @Autowired
    BaiVietReponsitory baiVietReponsitory;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    BaiVietDAO baiVietDAO;

    public BaiVietReponse getBaiVietById(Integer id){
        return BaiVietConvertor.converterByEntity(baiVietReponsitory.findById(id));
    }

    public List<BaiVietReponse> getListReponse(){
        return BaiVietConvertor.converterListEntity(baiVietReponsitory.findAll());
    }
    @Transactional
    public void deleteById(Integer id){
        baiVietReponsitory.deleteAllById(id);
    }

    @Transactional
    public void themBaiViet(BaiVietReponse baiVietReponse){
        User user1 = myUserDetailsService.getUserByName(baiVietReponse.getUser());
        BaiVietEntity baiVietEntity = new BaiVietEntity();
        baiVietEntity.setChuThich(baiVietReponse.getChuThich());
        baiVietEntity.setTenBaiViet(baiVietReponse.getTenBaiViet());
        baiVietEntity.setUser(user1);
        baiVietEntity.setNoiDung(baiVietReponse.getNoiDung());
        baiVietEntity.setHinhAnh(baiVietReponse.getTenHinhAnh());
        baiVietDAO.themBaiViet(baiVietEntity);
    }

    public void updateBaiViet(BaiVietReponse baiVietReponse){
        BaiVietEntity baiVietEntity = baiVietReponsitory.findById(baiVietReponse.getId());
        baiVietEntity.setNoiDung(baiVietReponse.getNoiDung());
        baiVietEntity.setTenBaiViet(baiVietReponse.getTenBaiViet());
        baiVietEntity.setChuThich(baiVietReponse.getChuThich());
        baiVietDAO.updateBaiVietEntity(baiVietEntity);
    }

    public List<BaiVietReponse> getListSeach(String seach, Integer first, Integer last){
        Pageable top = (Pageable) new PageRequest(first, last);
        return BaiVietConvertor.converterListEntity(baiVietReponsitory.findByTenBaiViet(seach, top));
    }


}
