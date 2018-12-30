package thuctapcongnhan.ttn.domain;

public class NguPhapReponse {

    private Integer id;
    private String tenNguPhap;
    private String url;
    private String noiDung;
    private Integer idBaiHoc;

    public NguPhapReponse() {
    }

    public NguPhapReponse(Integer id, String tenNguPhap, String url, String noiDung, Integer idBaiHoc) {
        this.id = id;
        this.tenNguPhap = tenNguPhap;
        this.url = url;
        this.noiDung = noiDung;
        this.idBaiHoc = idBaiHoc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenNguPhap() {
        return tenNguPhap;
    }

    public void setTenNguPhap(String tenNguPhap) {
        this.tenNguPhap = tenNguPhap;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
    public Integer getIdBaiHoc() {
        return idBaiHoc;
    }

    public void setIdBaiHoc(Integer idBaiHoc) {
        this.idBaiHoc = idBaiHoc;
    }

}
