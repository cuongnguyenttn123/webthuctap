package thuctapcongnhan.ttn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import thuctapcongnhan.ttn.domain.BaiHocResponse;
import thuctapcongnhan.ttn.entity.BaiHocEntity;
import thuctapcongnhan.ttn.entity.User;
import thuctapcongnhan.ttn.service.BaiHocService;
import thuctapcongnhan.ttn.service.MyUserDetailsService;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    BaiHocService baiHocService;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @GetMapping()
    public String getAdmin(){
        return "admin/dashboard";
    }

    @GetMapping("/{level}")
    public String getMinnaAdmin(@PathVariable String level, ModelMap modelMap){
        List<BaiHocResponse> lessonEntities = (List<BaiHocResponse>) baiHocService.getListBaiHocByLevel(level);
        modelMap.addAttribute("list", lessonEntities);
        modelMap.addAttribute("level", level);
        return "admin/adminlession";
    }

    @PostMapping("/thembaihoc")
    public String themBaiHoc(@RequestParam String tenBaiHoc, @RequestParam String level, @RequestParam String chuThich,
                             @RequestParam String user){
        User user1 = myUserDetailsService.getUserByName(user);
        BaiHocEntity baiHocEntity = new BaiHocEntity(tenBaiHoc, chuThich, level);
        baiHocEntity.setUser(user1);
        baiHocService.createBaiHocEntity(baiHocEntity);
        return "admin/dashboard";
    }

    @GetMapping("/xoa/{id}")
    public String deleteMinnaAdmin(@PathVariable Integer id){
        baiHocService.deleteBaiHocById(id);
        return "admin/dashboard";
    }




}
