package thuctapcongnhan.ttn.converter;

import thuctapcongnhan.ttn.domain.TuVungReponse;
import thuctapcongnhan.ttn.entity.BaiHocEntity;
import thuctapcongnhan.ttn.entity.TuVungEntity;

import java.util.ArrayList;
import java.util.List;

public class TuVungConverter {
    public static TuVungReponse converterByEntity(TuVungEntity tuVungEntity){
        TuVungReponse tuVungReponse = new TuVungReponse(tuVungEntity.getId(), tuVungEntity.getTuVung(),
                tuVungEntity.getKanJi()
        , tuVungEntity.getPhienAm(), tuVungEntity.getNghia(), tuVungEntity.getLessonEntity().getId());
        return tuVungReponse;
    }

    public static List<TuVungReponse> converterByTuVungEntity(List<TuVungEntity> tuVungEntitys){
        List<TuVungReponse> tuVungReponses = new ArrayList<TuVungReponse>();
        for (TuVungEntity tuVungEntity1: tuVungEntitys) {
            tuVungReponses.add(converterByEntity(tuVungEntity1));
        }
        return tuVungReponses;
    }
    public static List<TuVungReponse> converterByBaiHocEntity(BaiHocEntity baiHocEntity){
        List<TuVungReponse> tuVungReponses = converterByTuVungEntity(baiHocEntity.getVocabularyEntities());
        return tuVungReponses;
    }

}
