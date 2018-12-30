package thuctapcongnhan.ttn.domain;

import java.util.List;

public class BaiHocResponse {
    private Integer id;
    private String tenBaiHoc;
    private String chuThich;
    private String level;
    private List<NguPhapReponse> nguPhapReponse;
    private List<TuVungReponse> tuVungReponseList;

    public BaiHocResponse() {
    }

    public BaiHocResponse(Integer id, String tenBaiHoc, String chuThich, String level) {
        this.id = id;
        this.tenBaiHoc = tenBaiHoc;
        this.chuThich = chuThich;
        this.level = level;
        this.nguPhapReponse = nguPhapReponse;
        this.tuVungReponseList = tuVungReponseList;
    }

    public List<NguPhapReponse> getNguPhapReponse() {
        return nguPhapReponse;
    }

    public void setNguPhapReponse(List<NguPhapReponse> nguPhapReponse) {
        this.nguPhapReponse = nguPhapReponse;
    }

    public List<TuVungReponse> getTuVungReponseList() {
        return tuVungReponseList;
    }

    public void setTuVungReponseList(List<TuVungReponse> tuVungReponseList) {
        this.tuVungReponseList = tuVungReponseList;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenBaiHoc() {
        return tenBaiHoc;
    }

    public void setTenBaiHoc(String tenBaiHoc) {
        this.tenBaiHoc = tenBaiHoc;
    }

    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
    }
}
