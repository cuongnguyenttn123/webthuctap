package thuctapcongnhan.ttn.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users", catalog = "dbthuctapcongnhan", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
    private Set<UsersRoles> usersRoleses = new HashSet<UsersRoles>(0);
    public User() {
    }
    public User(final String username, final String password, final Boolean enabled,
                final Set<UsersRoles> usersRoleses) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.usersRoleses = usersRoleses;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UsersRoles> getUsersRoleses() {
        return usersRoleses;
    }

    public void setUsersRoleses(Set<UsersRoles> usersRoleses) {
        this.usersRoleses = usersRoleses;
    }

    @Transient
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (UsersRoles usersRoles: this.usersRoleses) {
            authorities.add(new SimpleGrantedAuthority(usersRoles.getRole().getName()));
        }
        return authorities;
    }
}
