package thuctapcongnhan.ttn.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
import java.util.List;

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

    @PostMapping(path = "/xulyupdate", produces = "text/plain; charset=utf-8")
    @ResponseBody
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String xuLyUpdate(@RequestParam String dataJson){
        ObjectMapper objectMapper = new ObjectMapper();
        BaiHocResponse baiHocResponse1 = null;
        try {
            BaiHocResponse baiHocResponse = objectMapper.readValue(dataJson, BaiHocResponse.class);
            baiHocResponse1 = baiHocResponse;
            baiHocService.updateBaiHoc(baiHocResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<BaiHocResponse> baiHocResponses = baiHocService.getListBaiHocByLevel(baiHocResponse1.getLevel());
        String html = "";

        for (BaiHocResponse baiHocResponse: baiHocResponses) {
            html+="<tr>";

                html+="<td>"+baiHocResponse.getTenBaiHoc()+"</td>";
                html+= "<td>"+ baiHocResponse.getChuThich()+ "</td>";
                html+= "<td>"+ baiHocResponse.getLevel()+"</td>";

                html+= "<td class='idlession' data-id='"+baiHocResponse.getId()
                        +"'><button class='update btn btn-primary'>CS</button> || <button class='updatenoidung btn btn-primary'> <a href='/admin/minna/chinhhsua/"
                        +baiHocResponse.getId()+"'>CS Nội Dung</a></button> || <a href='/admin/xoa/"+baiHocResponse.getId()+"'>Xóa</a></td>";

            html+="</tr>";
        }

        return html;
    }


    /*Update Tu vung*/
    @PostMapping(path = "/updatetuvung", produces = "application/json; charset=utf-8")
    @ResponseBody
    public TuVungReponse getTuVung(Integer id){
        TuVungReponse tuVungReponse = tuVungService.findById(id);
        return tuVungReponse;
    }


    @PostMapping(path = "/xulyupdatetuvung", produces = "text/plain; charset=utf-8")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @ResponseBody
    public String xuLyUpdateTuVung(@RequestParam String dataJson){
        ObjectMapper objectMapper = new ObjectMapper();
        TuVungReponse tuVungReponse1 = null;
        try {
            TuVungReponse tuVungReponse = objectMapper.readValue(dataJson, TuVungReponse.class);
            tuVungService.upDateTuVung(tuVungReponse);
            tuVungReponse1 = tuVungReponse;

        } catch (IOException e) {
            e.printStackTrace();
        }
        List<TuVungReponse> vocabularyResponses = baiHocService.getListTuVungById(tuVungReponse1.getIdBaiHoc());
        String html="";
        for (TuVungReponse tuvung: vocabularyResponses
             ) {
            html+="<tr>";
            html+="<td>"+tuvung.getTuVung()+"</td>";
            html+="<td>"+tuvung.getKanJi()+"</td>";
            html+="<td>"+tuvung.getPhienAm()+"</td>";
            html+="<td>"+tuvung.getNghia()+"</td>";
            html+="<td class='idlession' data-id='"+tuvung.getId()
                    +"'> <button class='updatetuvung btn btn-primary'>CS</button> || <a href='/admin/minna/xoa/tuvung/"
                    +tuvung.getId()+"'>Xóa</a></td>";
            html+="</tr>";
        }
        return html;
    }

    /*Update Ngu Phap*/
    @PostMapping(path = "/updatenguphap", produces = "application/json; charset=utf-8")
    @ResponseBody
    public NguPhapReponse getNguPhap(Integer id){
        NguPhapReponse nguPhapReponse = nguPhapService.getNguPhapById(id);
        return nguPhapReponse;
    }

    @PostMapping(path = "/xulyupdatenguphap", produces = "text/plain; charset=utf-8")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @ResponseBody
    public String xuLyUpdateNguPhap(@RequestParam String dataJson){
        ObjectMapper objectMapper = new ObjectMapper();
        NguPhapReponse nguPhapReponse1 = null;
        try {
            NguPhapReponse nguPhapReponse = objectMapper.readValue(dataJson, NguPhapReponse.class);
            nguPhapService.updateNguPhap(nguPhapReponse);
            nguPhapReponse1 = nguPhapReponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        String html = "";
        List<NguPhapReponse> nguPhapReponses = baiHocService.getNguPhapById(nguPhapReponse1.getIdBaiHoc());
        BaiHocResponse list = baiHocService.getBaiHocById(nguPhapReponse1.getIdBaiHoc());
        for (NguPhapReponse nguphap: nguPhapReponses) {

            html+="<tr>";
                html+="<td>"+nguphap.getTenNguPhap()+"</td>";
                html+="<td>"+nguphap.getUrl()+"</td>";
                html+="<td>"+nguphap.getNoiDung()+"</td>";
                html+="<td class='idnguphap' data-id='"+nguphap.getId()+"'data-idbaihoc = '"+list.getId()
                        +"'> <button class='updatenguphap btn btn-primary'>CS</button> || <a href='/admin/minna/xoa/nguphap/"+nguphap.getId()+"'>Xóa</a></td>";
            html+="</tr>";

        }
        return html;
    }

    @Autowired
    ServletContext context;
    @PostMapping("/xulyuploadhinhanh")
    @ResponseBody
    public String upLoadHinhAnh(MultipartHttpServletRequest request){
        String path_file_save = context.getRealPath("/resources/Images/baiviet/");
        Iterator<String> listName = request.getFileNames();
        MultipartFile mpf = request.getFile(listName.next());
        File file_name = new File(path_file_save + mpf.getOriginalFilename());
        System.out.println(mpf.getOriginalFilename());
        try {
            mpf.transferTo(file_name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mpf.getOriginalFilename();
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
