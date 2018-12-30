package thuctapcongnhan.ttn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thuctapcongnhan.ttn.entity.BaiVietEntity;
import thuctapcongnhan.ttn.reponsitory.BaiVietReponsitory;

@Service
public class BaiVietService {
    @Autowired
    BaiVietReponsitory baiVietReponsitory;

    public BaiVietEntity getBaiVietById(Integer id){
        return baiVietReponsitory.findById(id);
    }
}
