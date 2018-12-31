package thuctapcongnhan.ttn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thuctapcongnhan.ttn.domain.UserReponse;
import thuctapcongnhan.ttn.service.MyUserDetailsService;

@Controller
public class LoginController {
    @Autowired
    MyUserDetailsService myUserDetailsService;

    @RequestMapping(value = { "/login"})
    public String login(@RequestParam(value = "error", required = false) final String error, final Model model) {
        if (error != null) {
            model.addAttribute("message", "Login Failed!");
        }
        return "login";
    }
    @RequestMapping("/admin")
    public String admin() {
        return "admin/admin";
    }
    @RequestMapping("/user")
    public String user() {
        return "trangchu";
    }
    @RequestMapping("/logout")
    public String logout(final Model model) {
        model.addAttribute("message", "Logged out!");
        return "login";
    }

    @GetMapping("/dangky")
    public String getDangKy(){
        return "dangky";
    }


    @PostMapping("/dangky")
    public String getDangKyUser(@RequestParam String username, @RequestParam String password){
        String password1 = BCrypt.hashpw(password, BCrypt.gensalt(12));
        UserReponse userReponse = new UserReponse(username, password1);
        myUserDetailsService.createUser(userReponse);
        return "trangchu";
    }

}
