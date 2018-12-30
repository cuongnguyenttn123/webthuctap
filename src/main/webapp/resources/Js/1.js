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
        $("#xulythoat").removeClass("hidden");
        $("#xuly").addClass("hidden");
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








});

