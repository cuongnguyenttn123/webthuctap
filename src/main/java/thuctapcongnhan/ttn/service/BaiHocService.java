package thuctapcongnhan.ttn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thuctapcongnhan.ttn.converter.BaiHocConverter;
import thuctapcongnhan.ttn.converter.NguPhapConverter;
import thuctapcongnhan.ttn.converter.TuVungConverter;
import thuctapcongnhan.ttn.dao.BaiHocDAO;
import thuctapcongnhan.ttn.domain.BaiHocResponse;
import thuctapcongnhan.ttn.domain.NguPhapReponse;
import thuctapcongnhan.ttn.domain.TuVungReponse;
import thuctapcongnhan.ttn.entity.BaiHocEntity;
import thuctapcongnhan.ttn.reponsitory.BaiHocReponsitory;

import java.util.List;

@Service
public class BaiHocService {
    @Autowired
    BaiHocReponsitory baiHocReponsitory;

    @Autowired
    BaiHocDAO baiHocDAO;

    public BaiHocResponse getBaiHocById(Integer id){
        return BaiHocConverter.converterByEntity(baiHocReponsitory.findAllById(id));
    }
    public List<BaiHocResponse> getListBaiHoc(){
        return BaiHocConverter.converterListByEntity(baiHocReponsitory.findAll());
    }

    public List<BaiHocResponse> getListBaiHocByLevel(String level){
        return BaiHocConverter.converterListByEntity(baiHocReponsitory.findByLevel(level));
    }

    public List<TuVungReponse> getListTuVungById(Integer id){
        BaiHocEntity baiHocEntity = baiHocReponsitory.findAllById(id);
        return TuVungConverter.converterByBaiHocEntity(baiHocEntity);
    }

    public void deleteBaiHocById(Integer id){
        baiHocReponsitory.deleteById(id);
    }

    public void createBaiHocEntity(BaiHocEntity baiHocEntity){
        baiHocDAO.themBaiHoc(baiHocEntity);
    }

    public void updateBaiHoc(BaiHocEntity baiHocEntity){
        baiHocDAO.updateBaiHocEntity(baiHocEntity);
    }

    public List<NguPhapReponse> getNguPhapById(Integer id){
        BaiHocEntity baiHocEntity = baiHocReponsitory.findAllById(id);
        return NguPhapConverter.converterByBaiHocEntity(baiHocEntity);
    }

}
