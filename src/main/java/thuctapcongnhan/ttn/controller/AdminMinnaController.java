package thuctapcongnhan.ttn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import thuctapcongnhan.ttn.domain.BaiHocResponse;
import thuctapcongnhan.ttn.domain.NguPhapReponse;
import thuctapcongnhan.ttn.domain.TuVungReponse;
import thuctapcongnhan.ttn.service.BaiHocService;
import thuctapcongnhan.ttn.service.NguPhapService;
import thuctapcongnhan.ttn.service.TuVungService;

import java.util.List;

@Controller
@RequestMapping("/admin/minna")
public class AdminMinnaController {
    @Autowired
    BaiHocService baiHocService;

    @Autowired
    TuVungService tuVungService;

    @Autowired
    NguPhapService nguPhapService;


    @GetMapping("/chinhhsua/{idBaiHoc}")
    public String getLessionAdmin(@PathVariable Integer idBaiHoc, ModelMap modelMap){
        List<TuVungReponse> vocabularyResponses = baiHocService.getListTuVungById(idBaiHoc);
        BaiHocResponse baiHocResponse = baiHocService.getBaiHocById(idBaiHoc) ;
        List<NguPhapReponse> nguPhapReponses = baiHocService.getNguPhapById(idBaiHoc);
        modelMap.addAttribute("list", baiHocResponse);
        modelMap.addAttribute("voca", vocabularyResponses);
        modelMap.addAttribute("nguphap", nguPhapReponses);

        return "admin/adminminna";
    }


    @GetMapping("/xoa/tuvung/{id}")
    public String deleteMinnaAdmin(@PathVariable Integer id){
        tuVungService.deleteTuVungById(id);
        return "admin/dashboard";
    }

    @PostMapping("/themtuvung/{idBaiHoc}")
    public String themTuVung(@PathVariable Integer idBaiHoc, @RequestParam String tuVung,
                             @RequestParam String kanJi, @RequestParam String phienAm, @RequestParam String nghia){

        TuVungReponse tuVungReponse = new TuVungReponse();
        tuVungReponse.setIdBaiHoc(idBaiHoc);
        tuVungReponse.setTuVung(tuVung);
        tuVungReponse.setKanJi(kanJi);
        tuVungReponse.setNghia(nghia);
        tuVungReponse.setPhienAm(phienAm);
        tuVungService.createTuVung(tuVungReponse);
        return "admin/dashboard";
    }
    @GetMapping("/nguphap/{idBaiHoc}")
    public String themNguPhap(@PathVariable Integer idBaiHoc, ModelMap modelMap){
        modelMap.addAttribute("idBaiHoc", idBaiHoc);
        return "admin/adminnguphap";
    }



    @PostMapping("themnguphap/{idBaiHoc}")
    public String themNguPhap(@PathVariable Integer idBaiHoc, @RequestParam String tenNguPhap, @RequestParam String url,
                              @RequestParam String noiDung){
        NguPhapReponse nguPhapReponse = new NguPhapReponse();
        nguPhapReponse.setIdBaiHoc(idBaiHoc);
        nguPhapReponse.setTenNguPhap(tenNguPhap);
        nguPhapReponse.setNoiDung(noiDung);
        nguPhapReponse.setUrl(url);
        nguPhapService.createNguPhap(nguPhapReponse);
        return "admin/dashboard";
    }

    @GetMapping("/xoa/nguphap/{id}")
    public String deleteMinnaAdminNguPhap(@PathVariable Integer id){
        nguPhapService.deleteById(id);
        return "admin/dashboard";
    }



}
