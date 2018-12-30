package thuctapcongnhan.ttn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import thuctapcongnhan.ttn.domain.BaiHocResponse;
import thuctapcongnhan.ttn.domain.NguPhapReponse;
import thuctapcongnhan.ttn.domain.TuVungReponse;
import thuctapcongnhan.ttn.service.BaiHocService;
import thuctapcongnhan.ttn.service.TuVungService;

import java.util.List;

@Controller
@RequestMapping("/minna/")
public class
MinnaController {
    @Autowired
    BaiHocService baiHocService;

    @Autowired
    TuVungService tuVungService;


    @GetMapping("/{level}")
    public String getMinna(@PathVariable String level, ModelMap modelMap){
        List<BaiHocResponse> lessonEntities = baiHocService.getListBaiHocByLevel(level) ;
        modelMap.addAttribute("list", lessonEntities);
        modelMap.addAttribute("level", level);
        return "minna/detailminna";
    }

    @GetMapping("/lession/tuvung/{level}/{idBaiHoc}")

    public String getTuVung(@PathVariable Integer idBaiHoc, @PathVariable String level, ModelMap modelMap){
        List<TuVungReponse> vocabularyResponses = baiHocService.getListTuVungById(idBaiHoc);
        List<BaiHocResponse> lessonEntities = baiHocService.getListBaiHocByLevel(level) ;
        modelMap.addAttribute("list", lessonEntities);
        modelMap.addAttribute("voca", vocabularyResponses);
        return "minna/tuvung";
    }

    @GetMapping("/lession/nguphap/{level}/{idBaiHoc}")

    public String getNguPhap(@PathVariable Integer idBaiHoc, @PathVariable String level, ModelMap modelMap){
        List<NguPhapReponse> nguPhapReponse = baiHocService.getNguPhapById(idBaiHoc);
        List<BaiHocResponse> lessonEntities = baiHocService.getListBaiHocByLevel(level) ;
        modelMap.addAttribute("list", lessonEntities);
        modelMap.addAttribute("nguphap", nguPhapReponse);
        return "minna/nguphap";
    }


}
