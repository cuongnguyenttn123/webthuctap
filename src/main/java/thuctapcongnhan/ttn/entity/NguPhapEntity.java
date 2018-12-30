package thuctapcongnhan.ttn.entity;



import javax.persistence.*;

@Entity
@Table(name = "nguphap")
public class NguPhapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnguphap")
    private Integer id;
    @Column(name = "tennguphap")
    private String tenNguPhap;
    @Column(name = "url")
    private String url;
    @Column(name = "noidung")
    private String noiDung;
    @ManyToOne()
    @JoinColumn(name = "idbaihoc", nullable = false)
    private BaiHocEntity lessonEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BaiHocEntity getLessonEntity() {
        return lessonEntity;
    }

    public void setLessonEntity(BaiHocEntity lessonEntity) {
        this.lessonEntity = lessonEntity;
    }


    public String getTenNguPhap() {
        return tenNguPhap;
    }

    public void setTenNguPhap(String tenNguPhap) {
        this.tenNguPhap = tenNguPhap;
    }

    public String getNoiDung() {
        return noiDung;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }


}
