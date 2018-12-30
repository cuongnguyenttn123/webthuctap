package thuctapcongnhan.ttn.converter;

import thuctapcongnhan.ttn.domain.BaiHocResponse;
import thuctapcongnhan.ttn.entity.BaiHocEntity;

import java.util.ArrayList;
import java.util.List;

public class BaiHocConverter {
    public static BaiHocResponse converterByEntity(BaiHocEntity baiHocEntity){
        BaiHocResponse baiHocResponse = new BaiHocResponse(baiHocEntity.getId(), baiHocEntity.getTenBaiHoc(),
                baiHocEntity.getChuThich(),baiHocEntity.getLevel());
        baiHocResponse.setNguPhapReponse(NguPhapConverter.converterByEntity(baiHocEntity.getNguPhapEntityList()));
        baiHocResponse.setTuVungReponseList(TuVungConverter.converterByTuVungEntity(baiHocEntity.getVocabularyEntities()));
        return baiHocResponse;
    }

    public static List<BaiHocResponse> converterListByEntity(List<BaiHocEntity> baiHocEntities){
        List<BaiHocResponse> baiHocResponses = new ArrayList<BaiHocResponse>();
        for (BaiHocEntity baiHocEntity : baiHocEntities) {
            baiHocResponses.add(converterByEntity(baiHocEntity));
        }
        return baiHocResponses;
    }


}
