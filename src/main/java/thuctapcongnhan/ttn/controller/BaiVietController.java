package thuctapcongnhan.ttn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import thuctapcongnhan.ttn.domain.BaiVietReponse;
import thuctapcongnhan.ttn.service.BaiVietService;

import java.util.List;

@Controller
@RequestMapping("/baiviet")
public class BaiVietController {
    @Autowired
    BaiVietService baiVietService;
    @GetMapping
    public String getListBaiViet(ModelMap modelMap){
        List<BaiVietReponse> baiVietReponses = baiVietService.getListReponse();
        modelMap.addAttribute("listBV", baiVietReponses);
        return "baiviet/baiviet";
    }
    @GetMapping("/{idBaiViet}")
    public String getBaiVietById(@PathVariable Integer idBaiViet, ModelMap modelMap){
        BaiVietReponse baiVietReponse = baiVietService.getBaiVietById(idBaiViet);
        modelMap.addAttribute("baiviet", baiVietReponse);
        return "baiviet/detailbaiviet";
    }

    @PostMapping("/seach")
    public String timKiemBaiViet(@RequestParam String seach, ModelMap modelMap){
        List<BaiVietReponse> baiVietReponses = baiVietService.getListSeach(seach);
        modelMap.addAttribute("listBV", baiVietReponses);
        return "baiviet/timkiem";
    }


}
