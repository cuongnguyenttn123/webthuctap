package thuctapcongnhan.ttn.domain;

public class TuVungReponse {

    private Integer id;
    private String tuVung;
    private String kanJi;
    private String phienAm;
    private String nghia;
    private Integer idBaiHoc;

    public TuVungReponse(Integer id, String tuVung, String kanJi, String phienAm, String nghia, Integer idBaiHoc) {
        this.id = id;
        this.tuVung = tuVung;
        this.kanJi = kanJi;
        this.phienAm = phienAm;
        this.nghia = nghia;
        this.idBaiHoc = idBaiHoc;
    }

    public TuVungReponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTuVung() {
        return tuVung;
    }

    public void setTuVung(String tuVung) {
        this.tuVung = tuVung;
    }

    public String getKanJi() {
        return kanJi;
    }

    public void setKanJi(String kanJi) {
        this.kanJi = kanJi;
    }

    public String getPhienAm() {
        return phienAm;
    }

    public void setPhienAm(String phienAm) {
        this.phienAm = phienAm;
    }

    public String getNghia() {
        return nghia;
    }

    public void setNghia(String nghia) {
        this.nghia = nghia;
    }

    public Integer getIdBaiHoc() {
        return idBaiHoc;
    }

    public void setIdBaiHoc(Integer idBaiHoc) {
        this.idBaiHoc = idBaiHoc;
    }
}
