package thuctapcongnhan.ttn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thuctapcongnhan.ttn.converter.BaiHocConverter;
import thuctapcongnhan.ttn.converter.BaiVietConvertor;
import thuctapcongnhan.ttn.domain.BaiVietReponse;
import thuctapcongnhan.ttn.entity.BaiVietEntity;
import thuctapcongnhan.ttn.reponsitory.BaiVietReponsitory;

import java.util.List;

@Service
@Transactional
public class BaiVietService {
    @Autowired
    BaiVietReponsitory baiVietReponsitory;

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
}
