package thuctapcongnhan.ttn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import thuctapcongnhan.ttn.domain.BaiVietReponse;
import thuctapcongnhan.ttn.service.BaiVietService;

import java.util.List;

@Controller
@RequestMapping("/")
public class TrangChuController {

    @Autowired
    BaiVietService baiVietService;
    @GetMapping
    public String getTrangChu(ModelMap modelMap){
        List<BaiVietReponse> baiVietReponses = baiVietService.getListReponse();
        modelMap.addAttribute("listBV", baiVietReponses);
        return "trangchu";
    }
}
