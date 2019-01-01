package thuctapcongnhan.ttn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import thuctapcongnhan.ttn.domain.BaiHocResponse;
import thuctapcongnhan.ttn.domain.BaiVietReponse;
import thuctapcongnhan.ttn.service.BaiVietService;

import java.util.List;

@Controller
@RequestMapping("/admin/baiviet")
public class AdminBaiVietController {
    @Autowired
    BaiVietService baiVietService;

    @GetMapping()
    public String getListBaiViet(ModelMap modelMap){
        List<BaiVietReponse> baiHocResponses = baiVietService.getListReponse();
        modelMap.addAttribute("listBV", baiHocResponses);
        return "admin/adminbaiviet";
    }

    @GetMapping("/xoa/{id}")
    public String deleteBaiViet(@PathVariable Integer id){
        baiVietService.deleteById(id);
        return "admin/adminbaiviet";
    }

    @PostMapping("/thembaiviet")
    public String themBaiViet(@RequestParam String tenBaiViet, @RequestParam String chuThich,
                              @RequestParam String noiDung, @RequestParam String user, @RequestParam String tenHinhAnh){
        BaiVietReponse baiVietReponse = new BaiVietReponse();
        baiVietReponse.setTenBaiViet(tenBaiViet);
        baiVietReponse.setChuThich(chuThich);
        baiVietReponse.setNoiDung(noiDung);
        baiVietReponse.setUser(user);
        baiVietReponse.setTenHinhAnh(tenHinhAnh);
        baiVietService.themBaiViet(baiVietReponse);

        return "admin/dashboard";
    }

}
