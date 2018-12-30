package thuctapcongnhan.ttn.entity;

import javax.persistence.*;

@Entity
@Table(name = "tuvung")
public class TuVungEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtuvung")
    private Integer id;
    @Column(name = "tentuvung")
    private String tuVung;
    @Column(name = "kanji")
    private String kanJi;
    @Column(name = "phienam")
    private String phienAm;
    @Column(name = "nghia")
    private String nghia;


    @ManyToOne()
    @JoinColumn(name = "idbaihoc", nullable = false)
    private BaiHocEntity lessonEntity;

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

    public BaiHocEntity getLessonEntity() {
        return lessonEntity;
    }

    public void setLessonEntity(BaiHocEntity lessonEntity) {
        this.lessonEntity = lessonEntity;
    }
}
