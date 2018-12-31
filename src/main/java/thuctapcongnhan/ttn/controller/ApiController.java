package thuctapcongnhan.ttn.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import thuctapcongnhan.ttn.domain.BaiHocResponse;
import thuctapcongnhan.ttn.domain.NguPhapReponse;
import thuctapcongnhan.ttn.domain.TuVungReponse;
import thuctapcongnhan.ttn.entity.BaiHocEntity;
import thuctapcongnhan.ttn.service.BaiHocService;
import thuctapcongnhan.ttn.service.NguPhapService;
import thuctapcongnhan.ttn.service.TuVungService;

import java.io.IOException;

@Controller
@RequestMapping("/api")
public class ApiController {
    @Autowired
    BaiHocService baiHocService;

    @Autowired
    TuVungService tuVungService;

    @Autowired
    NguPhapService nguPhapService;


    @PostMapping(path = "/update", produces = "application/json; charset=utf-8")
    @ResponseBody
    public BaiHocResponse getLession( Integer id){
        BaiHocResponse baiHocResponse = baiHocService.getBaiHocById(id);
        return baiHocResponse;
    }

    @PostMapping(path = "/xulyupdate", produces = "application/json; charset=utf-8")
    @ResponseBody
    @JsonIgnoreProperties(ignoreUnknown = true)
    public BaiHocResponse xuLyUpdate(@RequestParam String dataJson){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            BaiHocResponse baiHocResponse = objectMapper.readValue(dataJson, BaiHocResponse.class);

            baiHocService.updateBaiHoc(baiHocResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /*Update Tu vung*/
    @PostMapping(path = "/updatetuvung", produces = "application/json; charset=utf-8")
    @ResponseBody
    public TuVungReponse getTuVung(Integer id){
        TuVungReponse tuVungReponse = tuVungService.findById(id);
        return tuVungReponse;
    }


    @PostMapping(path = "/xulyupdatetuvung", produces = "application/json; charset=utf-8")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String xuLyUpdateTuVung(@RequestParam String dataJson){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TuVungReponse tuVungReponse = objectMapper.readValue(dataJson, TuVungReponse.class);
            tuVungService.upDateTuVung(tuVungReponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "admin/dashboard";
    }

    /*Update Tu vung*/
    @PostMapping(path = "/updatenguphap", produces = "application/json; charset=utf-8")
    @ResponseBody
    public NguPhapReponse getNguPhap(Integer id){
        NguPhapReponse nguPhapReponse = nguPhapService.getNguPhapById(id);
        return nguPhapReponse;
    }


    @PostMapping(path = "/xulyupdatenguphap", produces = "application/json; charset=utf-8")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String xuLyUpdateNguPhap(@RequestParam String dataJson){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            NguPhapReponse nguPhapReponse = objectMapper.readValue(dataJson, NguPhapReponse.class);
            nguPhapService.updateNguPhap(nguPhapReponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "admin/dashboard";
    }

}
