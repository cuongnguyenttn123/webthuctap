package thuctapcongnhan.ttn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thuctapcongnhan.ttn.converter.TuVungConverter;
import thuctapcongnhan.ttn.dao.TuVungDAO;
import thuctapcongnhan.ttn.domain.TuVungReponse;
import thuctapcongnhan.ttn.entity.BaiHocEntity;
import thuctapcongnhan.ttn.entity.TuVungEntity;
import thuctapcongnhan.ttn.reponsitory.BaiHocReponsitory;
import thuctapcongnhan.ttn.reponsitory.TuVungReponsitory;

@Service
public class TuVungService {
    @Autowired
    TuVungReponsitory tuVungReponsitory;

    @Autowired
    TuVungDAO tuVungDAO;

    @Autowired
    BaiHocReponsitory baiHocReponsitory;

    public TuVungReponse findById(Integer id){
        return TuVungConverter.converterByEntity(tuVungReponsitory.findAllById(id));
    }
    @Transactional
    public void deleteTuVungById(Integer id){
        tuVungReponsitory.deleteById(id);
    }


    public void createTuVung(TuVungReponse tuVungReponse){
        BaiHocEntity baiHocEntity = baiHocReponsitory.findAllById(tuVungReponse.getIdBaiHoc());
        TuVungEntity tuVungEntity = new TuVungEntity();
        tuVungEntity.setTuVung(tuVungReponse.getTuVung());
        tuVungEntity.setNghia(tuVungReponse.getNghia());
        tuVungEntity.setKanJi(tuVungReponse.getKanJi());
        tuVungEntity.setPhienAm(tuVungReponse.getPhienAm());
        tuVungEntity.setLessonEntity(baiHocEntity);
        tuVungDAO.themTuVung(tuVungEntity);
    }

    public void upDateTuVung(TuVungReponse tuVungReponse){
        TuVungEntity tuVungEntity = tuVungReponsitory.findAllById(tuVungReponse.getId());
        tuVungEntity.setTuVung(tuVungReponse.getTuVung());
        tuVungEntity.setNghia(tuVungReponse.getNghia());
        tuVungEntity.setKanJi(tuVungReponse.getKanJi());
        tuVungEntity.setPhienAm(tuVungReponse.getPhienAm());
        tuVungDAO.updateTuVungEntity(tuVungEntity);
    }
}
