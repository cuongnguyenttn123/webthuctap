package thuctapcongnhan.ttn.domain;

public class BaiVietReponse {
    private Integer id;
    private String tenBaiViet;
    private String chuThich;
    private String noiDung;
    private String hinhAnh;

    private String user;

    public String get_csrf() {
        return _csrf;
    }

    public void set_csrf(String _csrf) {
        this._csrf = _csrf;
    }

    private String _csrf;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public BaiVietReponse(Integer id, String tenBaiViet, String chuThich, String noiDung) {
        this.id = id;
        this.tenBaiViet = tenBaiViet;
        this.chuThich = chuThich;
        this.noiDung = noiDung;
    }

    public BaiVietReponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenBaiViet() {
        return tenBaiViet;
    }

    public void setTenBaiViet(String tenBaiViet) {
        this.tenBaiViet = tenBaiViet;
    }

    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
