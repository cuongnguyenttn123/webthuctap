package thuctapcongnhan.ttn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import thuctapcongnhan.ttn.dao.UserDAO;
import thuctapcongnhan.ttn.reponsitory.UserReponsitory;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserReponsitory userReponsitory;
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        thuctapcongnhan.ttn.entity.User username1 = userReponsitory.findByUsername(username);
        if (username1 == null) {
            return null;
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new User(username, username1.getPassword(), enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, username1.getAuthorities());
    }

    public thuctapcongnhan.ttn.entity.User getUserByd(Integer id){
        return userReponsitory.findById(id);
    }

    public thuctapcongnhan.ttn.entity.User getUserByName(String user ){
        return userReponsitory.findByUsername(user);
    }


}