package thuctapcongnhan.ttn.converter;

import thuctapcongnhan.ttn.domain.NguPhapReponse;
import thuctapcongnhan.ttn.entity.BaiHocEntity;
import thuctapcongnhan.ttn.entity.NguPhapEntity;

import java.util.ArrayList;
import java.util.List;

public class NguPhapConverter {
    public static List<NguPhapReponse> converterByEntity(List<NguPhapEntity> nguPhapEntitys){
        List<NguPhapReponse> nguPhapReponses = new ArrayList<NguPhapReponse>();
        for (NguPhapEntity nguPhapEntity: nguPhapEntitys) {
            NguPhapReponse nguPhapReponse = new NguPhapReponse();
            nguPhapReponse.setId(nguPhapEntity.getId());
            nguPhapReponse.setNoiDung(nguPhapEntity.getNoiDung());
            nguPhapReponse.setUrl(nguPhapEntity.getUrl());
            nguPhapReponse.setTenNguPhap(nguPhapEntity.getTenNguPhap());
            nguPhapReponses.add(nguPhapReponse);
        }
        return nguPhapReponses;

    }

    public static List<NguPhapReponse> converterByBaiHocEntity(BaiHocEntity baiHocEntity){
        return converterByEntity(baiHocEntity.getNguPhapEntityList());
    }

    public static NguPhapReponse converterNguPhap(NguPhapEntity nguPhapEntity){
        NguPhapReponse nguPhapReponse = new NguPhapReponse();
        nguPhapReponse.setId(nguPhapEntity.getId());
        nguPhapReponse.setNoiDung(nguPhapEntity.getNoiDung());
        nguPhapReponse.setUrl(nguPhapEntity.getUrl());
        nguPhapReponse.setTenNguPhap(nguPhapEntity.getTenNguPhap());
        return nguPhapReponse;
    }
}
