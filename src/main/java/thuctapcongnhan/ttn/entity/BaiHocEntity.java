package thuctapcongnhan.ttn.entity;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "baihoc")
public class BaiHocEntity {

    @Id
    @Column(name = "idbaihoc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tenbaihoc")
    private String tenBaiHoc;

    @Column(name = "chuthich")
    private String chuThich;

    @Column(name = "level")
    private String level;

    @ManyToOne()
    @JoinColumn(name = "iduser", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lessonEntity", cascade = {CascadeType.ALL})
    private List<NguPhapEntity> nguPhapEntityList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lessonEntity", cascade = {CascadeType.ALL})
    private List<TuVungEntity> vocabularyEntities;

    public BaiHocEntity(String tenBaiHoc, String chuThich, String level) {
        this.tenBaiHoc = tenBaiHoc;
        this.chuThich = chuThich;
        this.level = level;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BaiHocEntity() {
    }

    public List<NguPhapEntity> getNguPhapEntityList() {
        return nguPhapEntityList;
    }

    public void setNguPhapEntityList(List<NguPhapEntity> nguPhapEntityList) {
        this.nguPhapEntityList = nguPhapEntityList;
    }

    public List<TuVungEntity> getVocabularyEntities() {
        return vocabularyEntities;
    }

    public void setVocabularyEntities(List<TuVungEntity> vocabularyEntities) {
        this.vocabularyEntities = vocabularyEntities;
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
