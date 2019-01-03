$(document).ready(function() {
  $('.navbar a.dropdown-toggle').on('click', function(e) {
     var $el = $(this);
     var $parent = $(this).offsetParent(".dropdown-menu");
     $(this).parent("li").toggleClass('open');
     if(!$parent.parent().hasClass('nav')) {
          $el.next().css({"top": $el[0].offsetTop, "left": $parent.outerWidth() - 4});
     }
     $('.nav li.open').not($(this).parents("li")).removeClass("open");
     return false;
    });
    var id ="";

    $("body").on("click", ".update", function () {
        $("#xulyupdate").removeClass("hidden");
        $("#xulythoat").removeClass("hidden");
        $("#xuly").addClass("hidden");
        id = $(this).closest("tr").find(".idlession").attr("data-id");

        $.ajax({
            url: "/api/update",
            type:"POST",
            data:{
                id : id
            },
            success: function (value) {
                console.log(value);
                $("#tenBaiHoc").val(value.tenBaiHoc);
                $("#chuThich").val(value.chuThich);
                $("#level").val(value.level);

            }
        })
    })



    /*$(".update").click(function () {

    })*/

    $("#xulythoat").click(function (event) {
        event.preventDefault();
        $("#xulyupdate").addClass("hidden");
        $("#xulyupdatebaiviet").addClass("hidden");
        $("#xulythoat").addClass("hidden");
        $("#xuly").removeClass("hidden");
    })

    $("body").on("click", "#xulyupdate", function (event) {
        event.preventDefault();
        var formData = $("#form-lession").serializeArray();
        json = {};
        $.each(formData, function(i, field){
            json[field.name] = field.value;
        });
        json["id"] = id;
        console.log(id);
        $.ajax({
            url: "/api/xulyupdate",
            type:"POST",
            data:{
                dataJson : JSON.stringify(json)
            },
            success: function (value) {
                var updatebaihoc = $("#table-baihoc").find("tbody");
                updatebaihoc.empty();
                updatebaihoc.append(value);
            }
        })
    })

    /*update tuvung*/
    var idTuVung = "";
    var idBaiHoc = "";
    $("body").on("click", ".updatetuvung", function () {
    /*$(".updatetuvung").click(function () {*/
        $("#xulyupdatetuvung").removeClass("hidden");
        $("#xulythoattuvung").removeClass("hidden");
        $("#xulytuvung").addClass("hidden");
        idTuVung = $(this).closest("tr").find(".idlession").attr("data-id");
        idBaiHoc = $(this).closest("tr").find(".idlession").attr("data-idbaihoc");
        $.ajax({
            url: "/api/updatetuvung",
            type:"POST",
            data:{
                id : idTuVung
            },
            success: function (value) {
                console.log(value);
                $("#tuVung").val(value.tuVung);
                $("#kanJi").val(value.kanJi);
                $("#phienAm").val(value.phienAm);
                $("#nghia").val(value.nghia);
            }
        })
    })

    $("#xulythoattuvung").click(function (event) {
        event.preventDefault();
        $("#xulyupdatetuvung").addClass("hidden");
        $("#xulythoattuvung").addClass("hidden");
        $("#xulytuvung").removeClass("hidden");
    })


    $("body").on("click", "#xulyupdatetuvung", function (event) {
    /*$("#xulyupdatetuvung").click(function (event) {*/
        event.preventDefault();
        var formData = $("#form-lession").serializeArray();
        json = {};
        $.each(formData, function(i, field){
            json[field.name] = field.value;
        });
        json["id"] = idTuVung;
        json["idBaiHoc"] = idBaiHoc;
        console.log(id);
        $.ajax({
            url: "/api/xulyupdatetuvung",
            type:"POST",
            data:{
                dataJson : JSON.stringify(json)
            },
            success: function (value) {
                alert(value);
                var updatetuvung = $("#table-tuvung").find("tbody");
                updatetuvung.empty();
                updatetuvung.append(value);
            }
        })
    })

    /*update nguphap*/
    var idNguPhap = "";
    $("body").on("click", ".updatenguphap", function () {
    /*$(".updatenguphap").click(function () {*/
        $("#xulyupdatenguphap").removeClass("hidden");
        $("#xulythoatnguphap").removeClass("hidden");
        $("#xulynguphap").addClass("hidden");
        idNguPhap = $(this).closest("tr").find(".idnguphap").attr("data-id");
        idBaiHoc = $(this).closest("tr").find(".idnguphap").attr("data-idbaihoc");
        $.ajax({
            url: "/api/updatenguphap",
            type:"POST",
            data:{
                id : idNguPhap
            },
            success: function (value) {
                $("#tenNguPhap").val(value.tenNguPhap);
                $("#url").val(value.url);
                $("#noiDung").val(value.noiDung);
            }
        })
    })

    $("#xulythoatnguphap").click(function (event) {
        event.preventDefault();
        $("#xulyupdatenguphap").addClass("hidden");
        $("#xulythoatnguphap").addClass("hidden");
        $("#xulynguphap").removeClass("hidden");
    })

    $("body").on("click", "#xulyupdatenguphap", function (event) {
    /*$("#xulyupdatenguphap").click(function (event) {*/
        event.preventDefault();
        var formData = $("#form-lession1").serializeArray();
        json = {};
        $.each(formData, function(i, field){
            json[field.name] = field.value;
        });
        json["id"] = idNguPhap;
        json["idBaiHoc"] = idBaiHoc;
        console.log(id);
        $.ajax({
            url: "/api/xulyupdatenguphap",
            type:"POST",
            data:{
                dataJson : JSON.stringify(json)
            },
            success: function (value) {
                var updatenguphap = $("#table-nguphap").find("tbody");
                updatenguphap.empty();
                updatenguphap.append(value);
            }
        })
    })





    /*update baiViet*/
    var idBaiViet = "";
    $("body").on("click", ".updatebaiviet", function () {
    /*$(".updatebaiviet").click(function () {*/
        $("#xulyupdatebaiviet").removeClass("hidden");
        $("#xulythoatbaiviet").removeClass("hidden");
        $("#xulybaiviet").addClass("hidden");
        idBaiViet = $(this).closest("tr").find(".idbaiviet").attr("data-id");
        $.ajax({
            url: "/api/updatebaiviet",
            type:"POST",
            data:{
                id : idBaiViet
            },
            success: function (value) {
                $("#tenBaiViet").val(value.tenBaiViet);
                $("#chuThich").val(value.chuThich);
                $("#noiDung").val(value.noiDung);
            }
        })
    })


    $("#xulythoatbaiviet").click(function (event) {
        event.preventDefault();
        $("#xulyupdatebaiviet").addClass("hidden");
        $("#xulythoatbaiviet").addClass("hidden");
        $("#xulybaiviet").removeClass("hidden");
    })
    $("body").on("click", "#xulyupdatebaiviet", function (event) {
    /*$("#xulyupdatebaiviet").click(function (event) {*/
        event.preventDefault();
        var formData = $("#form-baiviet").serializeArray();
        json = {};
        $.each(formData, function(i, field){
            json[field.name] = field.value;
        });
        json["id"] = idBaiViet;
        console.log(id);
        $.ajax({
            url: "/api/xulyupdatebaiviet",
            type:"POST",
            data:{
                dataJson : JSON.stringify(json)
            },
            success: function (value) {
                var updatebaiviet = $("#table-baiviet").find("tbody");
                updatebaiviet.empty();
                updatebaiviet.append(value);
            }
        })
    })
    var files = [];
    var tenhinh ="";
    $("#hinhanh").change(function(event) {
        files = event.target.files;
        tenhinh = files[0].name;
        var forms = new FormData();
        forms.append("file", files[0]);

        $.ajax({
            url: "/api/xulyuploadhinhanh",
            type:"POST",
            data:forms,
            contentType:false,
            processData: false,
            enctype: "multipart/form-data",
            success: function (value) {
                $("#tenHinhAnh").val(value);
            }
        })
    })
});

