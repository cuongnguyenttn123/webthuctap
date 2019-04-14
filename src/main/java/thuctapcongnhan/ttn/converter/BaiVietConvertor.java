package thuctapcongnhan.ttn.converter;

import thuctapcongnhan.ttn.domain.BaiVietReponse;
import thuctapcongnhan.ttn.entity.BaiVietEntity;

import java.util.ArrayList;
import java.util.List;

public class BaiVietConvertor {
    public static BaiVietReponse converterByEntity(BaiVietEntity baiVietEntity){
        BaiVietReponse baiVietReponse = new BaiVietReponse();
        baiVietReponse.setId(baiVietEntity.getId());
        baiVietReponse.setChuThich(baiVietEntity.getChuThich());
        baiVietReponse.setNoiDung(baiVietEntity.getNoiDung());
        baiVietReponse.setTenBaiViet(baiVietEntity.getTenBaiViet());
        baiVietReponse.setTenHinhAnh(baiVietEntity.getHinhAnh());
        return baiVietReponse;
    }

    public static List<BaiVietReponse> converterListEntity(List<BaiVietEntity> baiVietEntities){
        List<BaiVietReponse> baiVietReponses = new ArrayList<BaiVietReponse>();
        for (BaiVietEntity baiVietEntity: baiVietEntities) {
            BaiVietReponse baiVietReponse = converterByEntity(baiVietEntity);
            baiVietReponses.add(baiVietReponse);
        }
        return baiVietReponses;

    }
}
