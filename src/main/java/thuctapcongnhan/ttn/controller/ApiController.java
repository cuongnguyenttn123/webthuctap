package thuctapcongnhan.ttn.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import thuctapcongnhan.ttn.domain.BaiHocResponse;
import thuctapcongnhan.ttn.domain.BaiVietReponse;
import thuctapcongnhan.ttn.domain.NguPhapReponse;
import thuctapcongnhan.ttn.domain.TuVungReponse;
import thuctapcongnhan.ttn.entity.BaiHocEntity;
import thuctapcongnhan.ttn.service.BaiHocService;
import thuctapcongnhan.ttn.service.BaiVietService;
import thuctapcongnhan.ttn.service.NguPhapService;
import thuctapcongnhan.ttn.service.TuVungService;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Controller
@RequestMapping("/api")
public class ApiController {
    @Autowired
    BaiHocService baiHocService;

    @Autowired
    TuVungService tuVungService;

    @Autowired
    NguPhapService nguPhapService;

    @Autowired
    BaiVietService baiVietService;


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

    @Autowired
    ServletContext context;
    @PostMapping("/xulyuploadanh")
    @ResponseBody
    public String upLoadHinhAnh(MultipartHttpServletRequest request){
        String path_file_save = context.getRealPath("/resources/Image/baiviet/");
        Iterator<String> listName = request.getFileNames();
        MultipartFile mpf = request.getFile(listName.next());
        File file_name = new File(path_file_save + mpf.getOriginalFilename());
        System.out.println(file_name);
        try {
            mpf.transferTo(file_name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "admin/adminbaiviet";
    }



    /*Update Bai Viet*/
    @PostMapping(path = "/updatebaiviet", produces = "application/json; charset=utf-8")
    @ResponseBody
    public BaiVietReponse getBaiViet(Integer id){
        BaiVietReponse baiVietReponse = baiVietService.getBaiVietById(id);
        return baiVietReponse;
    }


    @PostMapping(path = "/xulyupdatebaiviet", produces = "application/json; charset=utf-8")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String xuLyUpdateBaiViet(@RequestParam String dataJson){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            BaiVietReponse baiHocResponse = objectMapper.readValue(dataJson, BaiVietReponse.class);
            baiVietService.updateBaiViet(baiHocResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "admin/dashboard";
    }

}
