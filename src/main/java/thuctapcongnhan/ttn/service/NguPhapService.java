package thuctapcongnhan.ttn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thuctapcongnhan.ttn.dao.NguPhapDAO;
import thuctapcongnhan.ttn.domain.NguPhapReponse;
import thuctapcongnhan.ttn.entity.BaiHocEntity;
import thuctapcongnhan.ttn.entity.NguPhapEntity;
import thuctapcongnhan.ttn.reponsitory.BaiHocReponsitory;
import thuctapcongnhan.ttn.reponsitory.NguPhapReponsitory;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class NguPhapService {
    @Autowired
    NguPhapReponsitory nguPhapReponsitory;

    @Autowired
    BaiHocReponsitory baiHocReponsitory;

    @Autowired
    NguPhapDAO nguPhapDAO;

    public NguPhapEntity getNguPhapById(Integer id){
        return nguPhapReponsitory.findAllById(id);
    }
    @Transactional
    public void deleteById(Integer id){
        nguPhapReponsitory.deleteById(id);
    }


    public void createNguPhap(NguPhapReponse nguPhapReponse){
        NguPhapEntity nguPhapEntity = new NguPhapEntity();
        BaiHocEntity baiHocEntity = baiHocReponsitory.findAllById(nguPhapReponse.getIdBaiHoc());
        nguPhapEntity.setUrl(nguPhapReponse.getUrl());
        nguPhapEntity.setTenNguPhap(nguPhapReponse.getTenNguPhap());
        nguPhapEntity.setNoiDung(nguPhapReponse.getNoiDung());
        nguPhapEntity.setLessonEntity(baiHocEntity);

    }
}
