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
    $(".update").click(function () {
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

    $("#xulythoat").click(function (event) {
        event.preventDefault();
        $("#xulyupdate").addClass("hidden");
        $("#xulyupdatebaiviet").addClass("hidden");
        $("#xulythoat").addClass("hidden");
        $("#xuly").removeClass("hidden");
    })


    $("#xulyupdate").click(function (event) {
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

            }
        })
    })

    /*update tuvung*/
    var idTuVung = "";
    $(".updatetuvung").click(function () {
        $("#xulyupdatetuvung").removeClass("hidden");
        $("#xulythoattuvung").removeClass("hidden");
        $("#xulytuvung").addClass("hidden");
        idTuVung = $(this).closest("tr").find(".idlession").attr("data-id");
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


    $("#xulyupdatetuvung").click(function (event) {
        event.preventDefault();
        var formData = $("#form-lession").serializeArray();
        json = {};
        $.each(formData, function(i, field){
            json[field.name] = field.value;
        });
        json["id"] = idTuVung;
        console.log(id);
        $.ajax({
            url: "/api/xulyupdatetuvung",
            type:"POST",
            data:{
                dataJson : JSON.stringify(json)
            },
            success: function (value) {

            }
        })
    })

    /*update nguphap*/
    var idNguPhap = "";
    $(".updatenguphap").click(function () {
        $("#xulyupdatenguphap").removeClass("hidden");
        $("#xulythoatnguphap").removeClass("hidden");
        $("#xulynguphap").addClass("hidden");
        idNguPhap = $(this).closest("tr").find(".idnguphap").attr("data-id");
        $.ajax({
            url: "/api/updatenguphap",
            type:"POST",
            data:{
                id : idNguPhap
            },
            success: function (value) {
                console.log(value);
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


    $("#xulyupdatenguphap").click(function (event) {
        event.preventDefault();
        var formData = $("#form-lession1").serializeArray();
        json = {};
        $.each(formData, function(i, field){
            json[field.name] = field.value;
        });
        json["id"] = idNguPhap;
        console.log(id);
        $.ajax({
            url: "/api/xulyupdatenguphap",
            type:"POST",
            data:{
                dataJson : JSON.stringify(json)
            },
            success: function (value) {

            }
        })
    })





    /*update baiViet*/
    var idBaiViet = "";
    $(".updatebaiviet").click(function () {
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
                console.log(value);
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


    $("#xulyupdatebaiviet").click(function (event) {
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
                alert(value);
            }
        })
    })






});

