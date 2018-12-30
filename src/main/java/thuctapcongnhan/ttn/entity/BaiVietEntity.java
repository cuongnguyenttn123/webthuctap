package thuctapcongnhan.ttn.entity;

import javax.persistence.*;

@Entity
@Table(name = "baiviet")
public class BaiVietEntity {
    @Id
    @Column(name = "idbaiviet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tenbaiviet")
    private String tenBaiViet;

    @Column(name = "noidung")
    private String noiDung;

    @ManyToOne()
    @JoinColumn(name = "iduser", nullable = false)
    private User user;

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

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
